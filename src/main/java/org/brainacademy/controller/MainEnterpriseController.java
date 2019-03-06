package org.brainacademy.controller;

import org.brainacademy.controller.form.EnterpriseForm;
import org.brainacademy.model.Enterprise;
import org.brainacademy.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Class controller to communicate with view HTML file and Repository.
 * It is realisation of CRUD principles
 */

@Controller
@RequestMapping("/enterprises")
public class MainEnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @Value("${errorEnt.message}")
    private String errorMessage;

    @GetMapping(value = { "/list" })
    public String enterpriseList(Model model) {
        model.addAttribute("enterprises", enterpriseService.getList());
        return "enterprises/list";
    }

    @GetMapping(value = { "/add" })
    public String showAddEnterprisePage(Model model) {
        EnterpriseForm enterpriseForm = new EnterpriseForm();
        model.addAttribute("enterpriseForm", enterpriseForm);
        return "enterprises/add";
    }

    @PostMapping(value = { "/add" })
    public String saveEnterprise(Model model, @ModelAttribute("enterpriseForm") EnterpriseForm enterpriseForm) {

        String name = enterpriseForm.getName();
        String address = enterpriseForm.getAddress();

        if (name != null && !name.isEmpty() && address != null && !address.isEmpty()) {
            Enterprise newEnterprise = new Enterprise();
            newEnterprise.setName(name);
            newEnterprise.setAddress(address);
            enterpriseService.save(newEnterprise);

            return "redirect:/enterprises/list";
        }
        model.addAttribute("errorEntMessage", errorMessage);
        return "enterprises/add";
    }

    @GetMapping(value = {"/edit"})
    public String showUpdateEnterprisePage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("enterpriseForm", new EnterpriseForm());
        model.addAttribute("enterprise", enterpriseService.getById(id));
        return "enterprises/edit";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
    public String updateEnterprise(@RequestParam("id") Long id, @ModelAttribute("enterpriseForm") EnterpriseForm enterpriseForm){
        Enterprise updatedEnterprise = enterpriseService.getById(id);
        String name = enterpriseForm.getName();
        String address = enterpriseForm.getAddress();
        if (name != null && !name.isEmpty()){
            updatedEnterprise.setName(name);
        }
        if (address != null && !address.isEmpty()){
            updatedEnterprise.setAddress(address);
        }

        enterpriseService.save(updatedEnterprise);
        return "redirect:/enterprises/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUpsImpl (@PathVariable("id") Long id){
        enterpriseService.deleteById(id);
        return "redirect:/enterprises/list";
    }
}

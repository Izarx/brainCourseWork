package org.brainacademy.controller;

import org.brainacademy.controller.form.EnterpriseForm;
import org.brainacademy.model.Enterprise;
import org.brainacademy.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

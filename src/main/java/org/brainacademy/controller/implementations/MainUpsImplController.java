package org.brainacademy.controller.implementations;

import org.brainacademy.controller.form.UpsImplForm;
import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.model.models.Ups;
import org.brainacademy.service.EnterpriseService;
import org.brainacademy.service.implementations.UpsImplService;
import org.brainacademy.service.models.ModelEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Class controller to communicate with view HTML file and Repository.
 * It is realisation of CRUD principles
 */

@Controller
@RequestMapping("/upses")
public class MainUpsImplController {

    @Autowired
    private UpsImplService upsImplService;

    @Autowired
    @Qualifier("ups")
    private ModelEquipmentService upsService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Value("${errorUpsImpl.message}")
    private String errorMessage;

    @GetMapping(value = {"/list"})
    public String upsesImplList(Model model){
        model.addAttribute("upsImples", upsImplService.getList());
        return "upses/list";
    }

    @GetMapping(value = {"/add"})
    public String showAddUpsImplPage(Model model) {
        model.addAttribute("upsImplForm", new UpsImplForm());
        model.addAttribute("upses", upsService.getListOfNames(upsService.getList()));
        model.addAttribute("enterprises", enterpriseService.getListOfNames());
        return "upses/add";
    }

    @PostMapping(value = {"/add"})
    public String saveUpsImpl (Model model, @ModelAttribute ("upsImplForm") UpsImplForm upsImplForm){

        String name = upsImplForm.getName();
        String serialNumber = upsImplForm.getSerialNumber();
        String upsModel = upsImplForm.getModel();
        String enterprise = upsImplForm.getEnterprise();

        if((name != null && !name.isEmpty()) && (serialNumber != null && !serialNumber.isEmpty()) &&
                (upsModel != null && !upsModel.isEmpty()) && (enterprise != null && !enterprise.isEmpty())){
            UpsImpl newUpsImpl = new UpsImpl();
            newUpsImpl.setName(name);
            newUpsImpl.setSerialNumber(serialNumber);
            newUpsImpl.setUps((Ups) upsService.getByName(upsModel));
            newUpsImpl.setEnterprise(enterpriseService.getByName(enterprise));
            newUpsImpl.setIsBroken(false);
            upsImplService.save(newUpsImpl);
            return "redirect:/upses/list";
        }

        return "upses/add";
    }

    @GetMapping(value = {"/edit"})
    public String showUpdateUpsImplPage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("upsImplForm", new UpsImplForm());
        model.addAttribute("upsImpl", upsImplService.getById(id));
        model.addAttribute("enterprises", enterpriseService.getListOfNames());
        return "upses/edit";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
    public String updateUpsImpl(@RequestParam("id") Long id, @ModelAttribute("upsImplForm") UpsImplForm upsImplForm){
        UpsImpl updatedUpsImpl = upsImplService.getById(id);
        String name = upsImplForm.getName();
        String serialNumber = upsImplForm.getSerialNumber();
        String enterprise = upsImplForm.getEnterprise();
        Boolean isBroken = upsImplForm.getIsBroken();
        if (name != null && !name.isEmpty()){
            updatedUpsImpl.setName(name);
        }
        if (serialNumber != null && !serialNumber.isEmpty()){
            updatedUpsImpl.setSerialNumber(serialNumber);
        }
        if (enterprise != null && !enterprise.isEmpty()){
            updatedUpsImpl.setEnterprise(enterpriseService.getByName(enterprise));
        }
        if (isBroken != null){
            updatedUpsImpl.setIsBroken(isBroken);
        }

        upsImplService.save(updatedUpsImpl);
        return "redirect:/upses/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUpsImpl (@PathVariable("id") Long id){
        upsImplService.deleteById(id);
        return "redirect:/upses/list";
    }


}

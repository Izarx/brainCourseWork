package org.brainacademy.controller.implementations;

import org.brainacademy.controller.form.UpsImplForm;
import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.service.implementations.UpsImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upses")
public class MainUpsImplController {

    @Autowired
    UpsImplService upsImplService;

    @Value("${errorUpsImpl.message}")
    private String errorMessage;

    @GetMapping(value = {"/list-examples"})
    public String upsesImplList(Model model){
        model.addAttribute("upsImples", upsImplService.getList());
        return "upses/list-examples";
    }

    @GetMapping(value = {"/add-example"})
    public String showAddUpsImplPage(Model model) {
        UpsImplForm upsImplForm = new UpsImplForm();
        model.addAttribute("upsImplForm", upsImplForm);
        return "upses/add-example";
    }

    @PostMapping(value = {"/add-example"})
    public String saveUpsImpl (Model model, @ModelAttribute ("upsImplForm") UpsImplForm upsImplForm){

        String name = upsImplForm.getName();
        String serialNumber = upsImplForm.getSerialNumber();

        if(name != null && !name.isEmpty() && serialNumber != null && !serialNumber.isEmpty() ){
            UpsImpl newUpsImpl = new UpsImpl();
            newUpsImpl.setName(name);
            newUpsImpl.setSerialNumber(serialNumber);
            newUpsImpl.setBroken(false);
            upsImplService.save(newUpsImpl);
            return "redirect:/upses/list-examples";
        }

        return "/add-example";
    }

}

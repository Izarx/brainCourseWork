package org.brainacademy.controller.upses;

import org.brainacademy.controller.form.UpsForm;
import org.brainacademy.model.upses.Ups;
import org.brainacademy.service.upses.UpsService;
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
public class MainUpsController {

    @Autowired
    UpsService upsService;

    @Value("${errorUps.message}")
    private String errorMessage;

    @GetMapping(value = { "/list" })
    public String upsesList (Model model) {
        model.addAttribute("upses", upsService.getList());
        return "upses/list";
    }

    @GetMapping(value = { "/add" })
    public String showAddEnterprisePage(Model model){
        UpsForm upsForm = new UpsForm();
        model.addAttribute("upsForm", upsForm);
        return "upses/add";
    }

    @PostMapping(value = {"/add"})
    public String saveUps(Model model, @ModelAttribute ("upsForm") UpsForm upsForm) {

        String name = upsForm.getName();
        Double price = upsForm.getPrice();

        if (name != null && !name.isEmpty() && price != null) {
            Ups newUps = new Ups();
            newUps.setName(name);
            newUps.setPrice(price);
            upsService.save(newUps);

            return "redirect:/upses/list";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "upses/add";
    }

}

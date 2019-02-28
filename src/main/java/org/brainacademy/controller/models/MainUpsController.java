package org.brainacademy.controller.models;

import org.brainacademy.controller.form.ModelEquipmentForm;
import org.brainacademy.model.models.Ups;
import org.brainacademy.model.models.UpsTypes;
import org.brainacademy.service.models.UpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/upses")
public class MainUpsController {

    @Autowired
    UpsService upsService;

    @Value("${errorModel.message}")
    private String errorMessage;

    @GetMapping(value = { "/list-models" })
    public String upsesList (Model model) {
        model.addAttribute("upses", upsService.getList());
        return "upses/list-models";
    }

    @GetMapping(value = { "/add-model" })
    public String showAddUpsPage(Model model){
        ModelEquipmentForm upsForm = new ModelEquipmentForm();
        model.addAttribute("upsForm", upsForm);
        model.addAttribute("upsTypes", getUpsTypes());
        return "upses/add-model";
    }

    @PostMapping(value = {"/add-model"})
    public String saveUps(Model model, @ModelAttribute ("upsForm") ModelEquipmentForm upsForm) {

        String name = upsForm.getName();
        Double price = upsForm.getPrice();
        String type = upsForm.getType();

        if (name != null && !name.isEmpty() && price != null) {
            Ups newUps = new Ups();
            newUps.setName(name);
            newUps.setPrice(price);
            newUps.setType(UpsTypes.valueOf(type));
            upsService.save(newUps);

            return "redirect:/upses/list-models";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "upses/add-model";
    }

    private List<String> getUpsTypes(){
        List<String> list = new ArrayList<>();
        for (UpsTypes t : UpsTypes.values()) {
            list.add(t.name());
        }
        return list;
    }

}
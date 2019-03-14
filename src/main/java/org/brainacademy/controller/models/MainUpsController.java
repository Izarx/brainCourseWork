package org.brainacademy.controller.models;

import org.brainacademy.controller.form.ModelEquipmentForm;
import org.brainacademy.model.models.Ups;
import org.brainacademy.model.models.UpsType;
import org.brainacademy.service.models.ModelEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/upses")
public class MainUpsController {

    @Autowired
    @Qualifier("ups")
    private ModelEquipmentService upsService;

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
        model.addAttribute("upsTypes", upsService.getTypes());
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
            newUps.setType(UpsType.valueOf(type));
            upsService.save(newUps);

            return "redirect:/upses/list-models";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "upses/add-model";
    }

    @GetMapping(value = {"/edit-model"})
    public String showUpdateUpsPage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("upsForm", new ModelEquipmentForm());
        model.addAttribute("ups", upsService.getById(id));
        model.addAttribute("upsTypes", upsService.getTypes());
        return "upses/edit-model";
    }

    @RequestMapping(value = {"/edit-model"}, method = RequestMethod.PUT)
    public String updateUps(@RequestParam("id") Long id, @ModelAttribute("upsForm") ModelEquipmentForm upsForm){
        Ups updatedUps = (Ups) upsService.getById(id);
        String name = upsForm.getName();
        Double price = upsForm.getPrice();
        if (name != null && !name.isEmpty()){
            updatedUps.setName(name);
        }
        if (price != null){
            updatedUps.setPrice(price);
        }

        upsService.save(updatedUps);
        return "redirect:/upses/list-models";
    }

    @RequestMapping("/delete-model/{id}")
    public String deleteUps (@PathVariable("id") Long id){
        upsService.deleteById(id);
        return "redirect:/upses/list-models";
    }
}
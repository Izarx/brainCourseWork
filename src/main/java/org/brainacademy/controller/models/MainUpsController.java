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
@RequestMapping("/upses/models")
public class MainUpsController {

    @Autowired
    @Qualifier("ups")
    private ModelEquipmentService upsService;

    @Value("${errorModel.message}")
    private String errorMessage;

    @GetMapping(value = { "/list" })
    public String upsesList (Model model) {
        model.addAttribute("upses", upsService.getList());
        return "upses/models/list";
    }

    @GetMapping(value = { "/add" })
    public String showAddUpsPage(Model model){
        ModelEquipmentForm upsForm = new ModelEquipmentForm();
        model.addAttribute("upsForm", upsForm);
        model.addAttribute("upsTypes", upsService.getTypes());
        return "upses/models/add";
    }

    @PostMapping(value = {"/add"})
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

            return "redirect:/upses/models/list";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "upses/models/add";
    }

    @GetMapping(value = {"/edit"})
    public String showUpdateUpsPage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("upsForm", new ModelEquipmentForm());
        model.addAttribute("ups", upsService.getById(id));
        model.addAttribute("upsTypes", upsService.getTypes());
        return "upses/models/edit";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
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
        return "redirect:/upses/models/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUps (@PathVariable("id") Long id){
        upsService.deleteById(id);
        return "redirect:/upses/models/list";
    }
}
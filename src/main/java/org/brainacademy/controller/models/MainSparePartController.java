package org.brainacademy.controller.models;

import org.brainacademy.controller.form.ModelEquipmentForm;
import org.brainacademy.model.models.SparePart;
import org.brainacademy.model.models.SparePartType;
import org.brainacademy.service.models.ModelEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spares")
public class MainSparePartController {

    @Autowired
    @Qualifier("sparePart")
    private ModelEquipmentService sparePartService;

    @Value("${errorModel.message}")
    private String errorMessage;

    @GetMapping(value = "/list-models")
    public String sparePartsList(Model model){
        model.addAttribute("spareParts", sparePartService.getList());
        return "spares/list-models";
    }

    @GetMapping(value = "/add-model")
    public String showAddSparesPage(Model model){
        model.addAttribute("modelEquipmentForm", new ModelEquipmentForm());
        model.addAttribute("sparePartTypes", sparePartService.getTypes());
        return "spares/add-model";
    }

    @PostMapping(value = "/add-model")
    public String saveSparePart(Model model, @ModelAttribute ("modelEquipmentForm") ModelEquipmentForm modelEquipmentForm) {
        String name = modelEquipmentForm.getName();
        Double price = modelEquipmentForm.getPrice();
        String type = modelEquipmentForm.getType().toUpperCase();

        if (name != null && !name.isEmpty() && price != null) {
            SparePart sparePart = new SparePart();
            sparePart.setName(name);
            sparePart.setPrice(price);
            sparePart.setType(SparePartType.valueOf(type));
            sparePartService.save(sparePart);

            return "redirect:/spares/list-models";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "spares/add-model";
    }

    @GetMapping(value = {"/edit-model"})
    public String showUpdateSparesPage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("modelEquipmentForm", new ModelEquipmentForm());
        model.addAttribute("spare", sparePartService.getById(id));
        model.addAttribute("sparePartTypes", sparePartService.getTypes());
        return "spares/edit-model";
    }

    @RequestMapping(value = {"/edit-model"}, method = RequestMethod.PUT)
    public String updateSparePart(@RequestParam("id") Long id, @ModelAttribute("modelEquipmentForm") ModelEquipmentForm modelEquipmentForm){
        SparePart updatedSparePart = (SparePart) sparePartService.getById(id);
        String name = modelEquipmentForm.getName();
        Double price = modelEquipmentForm.getPrice();
        if (name != null && !name.isEmpty()){
            updatedSparePart.setName(name);
        }
        if (price != null){
            updatedSparePart.setPrice(price);
        }

        sparePartService.save(updatedSparePart);
        return "redirect:/spares/list-models";
    }

    @RequestMapping("/delete-model/{id}")
    public String deleteSparePart (@PathVariable("id") Long id){
        sparePartService.deleteById(id);
        return "redirect:/spares/list-models";
    }
}

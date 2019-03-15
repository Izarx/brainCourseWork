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
@RequestMapping("/spares/models")
public class MainSparePartController {

    @Autowired
    @Qualifier("sparePart")
    private ModelEquipmentService sparePartService;

    @Value("${errorModel.message}")
    private String errorMessage;

    @GetMapping(value = "/list")
    public String sparePartsList(Model model){
        model.addAttribute("spareParts", sparePartService.getList());
        return "spares/models/list";
    }

    @GetMapping(value = "/add")
    public String showAddSparesPage(Model model){
        model.addAttribute("modelEquipmentForm", new ModelEquipmentForm());
        model.addAttribute("sparePartTypes", sparePartService.getTypes());
        return "spares/models/add";
    }

    @PostMapping(value = "/add")
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

            return "redirect:/spares/models/list";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "spares/models/add";
    }

    @GetMapping(value = {"/edit"})
    public String showUpdateSparesPage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("modelEquipmentForm", new ModelEquipmentForm());
        model.addAttribute("spare", sparePartService.getById(id));
        model.addAttribute("sparePartTypes", sparePartService.getTypes());
        return "spares/models/edit";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
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
        return "redirect:/spares/models/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteSparePart (@PathVariable("id") Long id){
        sparePartService.deleteById(id);
        return "redirect:/spares/models/list";
    }
}

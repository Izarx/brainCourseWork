package org.brainacademy.controller.models;

import org.brainacademy.controller.form.ModelEquipmentForm;
import org.brainacademy.model.models.SparePart;
import org.brainacademy.model.models.SparePartTypes;
import org.brainacademy.service.models.SparePartService;
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
@RequestMapping("/spares")
public class MainSparePartController {

    @Autowired
    SparePartService sparePartService;

    @Value("${errorModel.message}")
    private String errorMessage;

    @GetMapping(value = "/list-models")
    public String sparePartsList(Model model){
        model.addAttribute("spareParts", sparePartService.getList());
        return "spares/list-models";
    }

    @GetMapping(value = "/add-model")
    public String showAddSparesPage(Model model){
        ModelEquipmentForm modelEquipmentForm = new ModelEquipmentForm();
        model.addAttribute("modelEquipmentForm", modelEquipmentForm);
        model.addAttribute("sparePartTypes", getSparePartTypes());
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
            sparePart.setType(SparePartTypes.valueOf(type));
            sparePartService.save(sparePart);

            return "redirect:/spares/list-models";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "spares/add-model";
    }

    private List<String> getSparePartTypes(){
        List<String> list = new ArrayList<>();
        for (SparePartTypes t : SparePartTypes.values()) {
            list.add(t.name());
        }
        return list;
    }
}

package org.brainacademy.controller.implementations;

import org.brainacademy.controller.form.BatteryForm;
import org.brainacademy.model.implementations.Battery;
import org.brainacademy.model.models.SparePart;
import org.brainacademy.model.models.SparePartType;
import org.brainacademy.service.implementations.BatteryService;
import org.brainacademy.service.implementations.UpsImplService;
import org.brainacademy.service.models.ModelEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/spares/batteries")
public class MainBatteryController {

    @Autowired
    BatteryService batteryService;

    @Autowired
    UpsImplService upsImplService;

    @Autowired
    @Qualifier("sparePart")
    ModelEquipmentService modelService;

    @GetMapping(value = {"/list"})
    public String batteriesList (Model model){
        model.addAttribute("batteries", batteryService.getList());
        return "spares/batteries/list";
    }

    @GetMapping(value = {"/add"})
    public String addBattery (Model model){
        model.addAttribute("batteryForm", new BatteryForm());
        model.addAttribute("models", modelService.getListOfNames(modelService.getListByType(SparePartType.BATTERY)));
        model.addAttribute("upses", upsImplService.getListOfNames());
        return "spares/batteries/add";
    }

    @PostMapping(value = {"/add"})
    public String saveBattery (Model model, @ModelAttribute ("batteryForm") BatteryForm batteryForm){
        String serialNumber = batteryForm.getSerialNumber();
        String sparePartModel = batteryForm.getModel();
        String upsImpl = batteryForm.getUps();
        LocalDate dateFactory = batteryForm.getDateFactory();

        if ((serialNumber != null && !serialNumber.isEmpty()) && (sparePartModel != null && !sparePartModel.isEmpty())
                && (upsImpl != null && !upsImpl.isEmpty()) && (dateFactory != null)){
            Battery newBattery = new Battery();
            newBattery.setSerialNumber(serialNumber);
            newBattery.setModel((SparePart) modelService.getByName(sparePartModel));
            newBattery.setUps(upsImplService.getByName(upsImpl));
            newBattery.setDateFactory(dateFactory);
            newBattery.setIsBroken(false);
            batteryService.save(newBattery);

            return "redirect:/spares/batteries/list";
        }

        return "spares/batteries/add";
    }

}

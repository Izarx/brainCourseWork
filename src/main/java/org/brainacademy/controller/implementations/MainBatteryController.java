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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = {"/edit"})
    public String editBattery(Model model, @RequestParam("id") Long id) {
        model.addAttribute("batteryForm", new BatteryForm());
        model.addAttribute("battery", batteryService.getById(id));
        model.addAttribute("models", modelService.getListOfNames(modelService.getListByType(SparePartType.BATTERY)));
        model.addAttribute("upses", upsImplService.getListOfNames());
        return "spares/batteries/edit";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
    public String updateBattery(@RequestParam("id") Long id, @ModelAttribute ("batteryForm") BatteryForm batteryForm){
        Battery updatedBattery = batteryService.getById(id);
        String serialNumber = batteryForm.getSerialNumber();
        String batteryModel = batteryForm.getModel();
        String upsImpl = batteryForm.getUps();
        LocalDate dateFactory = batteryForm.getDateFactory();
        Boolean isBroken = batteryForm.getIsBroken();

        if (serialNumber != null && !serialNumber.isEmpty()){
            updatedBattery.setSerialNumber(serialNumber);
        }
        else {
            updatedBattery.setSerialNumber(updatedBattery.getSerialNumber());
        }
        if (batteryModel != null && !batteryModel.isEmpty()){
            updatedBattery.setModel((SparePart) modelService.getByName(batteryModel));
        }
        else {
            updatedBattery.setModel(updatedBattery.getModel());
        }
        if (upsImpl != null && !upsImpl.isEmpty()) {
            updatedBattery.setUps(upsImplService.getByName(upsImpl));
        }
        else {
            updatedBattery.setUps(updatedBattery.getUps());
        }
        if (dateFactory != null && !dateFactory.isAfter(LocalDate.now())) {
            updatedBattery.setDateFactory(dateFactory);
        }
        else {
            updatedBattery.setDateFactory(updatedBattery.getDateFactory());
        }
        if (isBroken != null) {
            updatedBattery.setIsBroken(isBroken);
        }
        else {
            updatedBattery.setIsBroken(updatedBattery.getIsBroken());
        }

        batteryService.save(updatedBattery);

        return "redirect:/spares/batteries/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBattery (@PathVariable("id") Long id) {
        batteryService.deleteById(id);
        return "redirect:/spares/batteries/list";
    }

}

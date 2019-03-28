package org.brainacademy.controller.implementations;

import org.brainacademy.controller.form.NetworkCardForm;
import org.brainacademy.model.implementations.NetworkCard;
import org.brainacademy.model.models.SparePart;
import org.brainacademy.model.models.SparePartType;
import org.brainacademy.service.implementations.NetworkCardService;
import org.brainacademy.service.implementations.UpsImplService;
import org.brainacademy.service.models.ModelEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spares/nics")
public class MainNetworkCardController {

    @Autowired
    NetworkCardService networkCardService;

    @Autowired
    UpsImplService upsImplService;

    @Autowired
    @Qualifier ("sparePart")
    ModelEquipmentService modelService;

    @GetMapping(value = {"/list"})
    public String networkCardsList(Model model){
        model.addAttribute("networkCards", networkCardService.getList());
        return "spares/nics/list";
    }

    @GetMapping(value = {"/add"})
    public String addNetworkCard(Model model){
        model.addAttribute("networkCardForm", new NetworkCardForm());
        model.addAttribute("models", modelService.getListOfNames(modelService.getListByType(SparePartType.NETWORK_CARD)));
        model.addAttribute("upses", upsImplService.getListOfNames());
        return "spares/nics/add";
    }

    @PostMapping(value = {"/add"})
    public String saveNetworkCard (Model model, @ModelAttribute ("networkCardForm") NetworkCardForm networkCardForm){
        String name = networkCardForm.getName();
        String serialNumber = networkCardForm.getSerialNumber();
        String sparePartModel = networkCardForm.getModel();
        String upsImpl = networkCardForm.getUps();

        if ((name != null && !name.isEmpty()) && (serialNumber != null && !serialNumber.isEmpty()) &&
                (sparePartModel != null && !sparePartModel.isEmpty()) && (upsImpl != null && !upsImpl.isEmpty())){

            NetworkCard newNetworkCard = new NetworkCard();
            newNetworkCard.setName(name);
            newNetworkCard.setSerialNumber(serialNumber);
            newNetworkCard.setModel((SparePart) modelService.getByName(sparePartModel));
            newNetworkCard.setUps(upsImplService.getByName(upsImpl));
            newNetworkCard.setIsBroken(false);
            networkCardService.save(newNetworkCard);

            return "redirect:/spares/nics/list";
        }
        return "spares/nics/add";
    }

    @GetMapping(value = {"/edit"})
    public String editNetworkCard(Model model, @RequestParam("id") Long id){
        model.addAttribute("networkCardForm", new NetworkCardForm());
        model.addAttribute("networkCard", networkCardService.getById(id));
        model.addAttribute("models", modelService.getListOfNames(modelService.getListByType(SparePartType.NETWORK_CARD)));
        model.addAttribute("upses", upsImplService.getListOfNames());
        return "spares/nics/edit";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
    public String updateNetworkCard(@RequestParam("id") Long id, @ModelAttribute("networkCardForm") NetworkCardForm networkCardForm){
        NetworkCard updatedNetworkCard = networkCardService.getById(id);
        String name = networkCardForm.getName();
        String serialNumber = networkCardForm.getSerialNumber();
        String sparePart = networkCardForm.getModel();
        String upsImpl = networkCardForm.getUps();
        Boolean isBroken = networkCardForm.getIsBroken();
        if (name != null && !name.isEmpty()){
            updatedNetworkCard.setName(name);
        }
        if (serialNumber != null && !serialNumber.isEmpty()){
            updatedNetworkCard.setSerialNumber(serialNumber);
        }
        if (sparePart != null && !sparePart.isEmpty()){
            updatedNetworkCard.setModel((SparePart) modelService.getByName(sparePart));
        }
        if (upsImpl != null && !upsImpl.isEmpty()) {
            updatedNetworkCard.setUps(upsImplService.getByName(upsImpl));
        }
        if (isBroken != null){
            updatedNetworkCard.setIsBroken(isBroken);
        }

        networkCardService.save(updatedNetworkCard);
        return "redirect:/spares/nics/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteNetworkCard (@PathVariable("id") Long id){
        networkCardService.deleteById(id);
        return "redirect:/spares/nics/list";
    }

}

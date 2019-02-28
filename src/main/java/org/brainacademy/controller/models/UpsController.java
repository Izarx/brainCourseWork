package org.brainacademy.controller.models;

import org.brainacademy.model.models.ModelEquipment;
import org.brainacademy.model.models.Ups;
import org.brainacademy.service.models.UpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class controller for handling REST requests. Entity to use db is ups
 */

@RestController
@RequestMapping("/api/upses")
public class UpsController {

    @Autowired
    private UpsService upsService;

    @GetMapping(value = "/list-models")
    public ResponseEntity<List<ModelEquipment>> upsDetails(){
        List<ModelEquipment> upsDetails = upsService.getList();
        return new ResponseEntity<List<ModelEquipment>>(upsDetails, HttpStatus.OK);
    }

    @PostMapping(value = "/add-model")
    public ResponseEntity<?> saveUps( @RequestBody Ups ups) {

        upsService.save(ups);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

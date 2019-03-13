package org.brainacademy.controller.models;

import org.brainacademy.model.models.Ups;
import org.brainacademy.service.models.ModelEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("ups")
    private ModelEquipmentService upsService;

    @GetMapping(value = "/list-models")
    public ResponseEntity<List<Ups>> upsDetails(){
        List<Ups> upsDetails = upsService.getList();
        return new ResponseEntity<>(upsDetails, HttpStatus.OK);
    }

    @PostMapping(value = "/add-model")
    public ResponseEntity<?> saveUps( @RequestBody Ups ups) {

        upsService.save(ups);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

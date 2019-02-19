package org.brainacademy.controller.upses;

import org.brainacademy.model.Enterprise;
import org.brainacademy.model.upses.Ups;
import org.brainacademy.service.upses.UpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class controller for handling REST requests. Entity to use db is ups
 */

@RestController
@RequestMapping("/upses/api")
public class UpsController {

    @Autowired
    private UpsService upsService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Ups>> upsDetails(){
        List<Ups> upsDetails = upsService.getList();
        return new ResponseEntity<List<Ups>>(upsDetails, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveUps( @RequestBody Ups ups) {

        upsService.save(ups);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

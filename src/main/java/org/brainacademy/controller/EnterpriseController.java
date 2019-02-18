package org.brainacademy.controller;


import org.brainacademy.model.Enterprise;
import org.brainacademy.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class controller for handling REST requests. Entity to use db is Enterprise
 */

@RestController
@RequestMapping("/enterprises/api")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Enterprise>> enterpriseDetails(){
        List<Enterprise> enterpriseDetails = enterpriseService.getList();
        return new ResponseEntity<List<Enterprise>>(enterpriseDetails, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveEnterpise( @RequestBody Enterprise enterprise) {

        enterpriseService.save(enterprise);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

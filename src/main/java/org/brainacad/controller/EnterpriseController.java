package org.brainacad.controller;


import org.brainacad.dao.EnterprisesRepository;
import org.brainacad.model.Enterprise;
import org.brainacad.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Class controller for handling REST requests. Entity to use db is Enterprise
 */


@RestController
@RequestMapping("/api")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping(value = "/enterprises")
    public ResponseEntity<List<Enterprise>> enterpriseDetails(){
        List<Enterprise> enterpriseDetails = enterpriseService.getList();
        return new ResponseEntity<List<Enterprise>>(enterpriseDetails, HttpStatus.OK);
    }

    @PostMapping(value = "/enterpriseAdd")
    public ResponseEntity<?> saveEnterpise( @RequestBody Enterprise enterprise) {

        enterpriseService.save(enterprise);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

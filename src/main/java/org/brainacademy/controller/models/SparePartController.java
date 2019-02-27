package org.brainacademy.controller.models;


import org.brainacademy.model.models.SparePart;
import org.brainacademy.service.models.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spares")
public class SparePartController {

    @Autowired
    SparePartService sparePartService;

    @GetMapping(value = "/list-models")
    public ResponseEntity<List<SparePart>> sparePartDetail() {
        List<SparePart> sparePartDetail = sparePartService.getList();
        return new ResponseEntity<List<SparePart>>(sparePartDetail, HttpStatus.OK);
    }

    @PostMapping(value = "/add-model")
    public ResponseEntity<?> saveSpare(@RequestBody SparePart sparePart) {
        sparePartService.save(sparePart);
        return new ResponseEntity<> (HttpStatus.OK);
    }

}

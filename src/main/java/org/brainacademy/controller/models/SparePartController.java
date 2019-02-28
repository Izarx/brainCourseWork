package org.brainacademy.controller.models;


import org.brainacademy.model.models.ModelEquipment;
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
    public ResponseEntity<List<ModelEquipment>> sparePartDetail() {
        List<ModelEquipment> sparePartDetail = sparePartService.getList();
        return new ResponseEntity<List<ModelEquipment>>(sparePartDetail, HttpStatus.OK);
    }

    @PostMapping(value = "/add-model")
    public ResponseEntity<?> saveSpare(@RequestBody SparePart sparePart) {
        sparePartService.save(sparePart);
        return new ResponseEntity<> (HttpStatus.OK);
    }

}

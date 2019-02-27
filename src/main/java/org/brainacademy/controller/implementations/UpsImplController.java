package org.brainacademy.controller.implementations;

import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.service.implementations.UpsImplService;
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
public class UpsImplController {

    @Autowired
    private UpsImplService upsImplService;

    @GetMapping(value = { "/list-examples" })
    public ResponseEntity<List<UpsImpl>> upsImplDetails(){
        List<UpsImpl> upsImplDetails = upsImplService.getList();
        return new ResponseEntity<List<UpsImpl>>(upsImplDetails, HttpStatus.OK);
    }

    @PostMapping(value = { "/add-example" })
    public ResponseEntity<?> saveUpsImpl(@RequestBody UpsImpl upsImpl){
        upsImplService.save(upsImpl);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.entity.Odontologist;
import com.dentalclinic.clinic.service.IOdontologistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologist")
public class OdontologistController {
    private IOdontologistService odontologistService;

    public OdontologistController(IOdontologistService odontologistService) {
        this.odontologistService = odontologistService;
    }
    @PostMapping
    public ResponseEntity<Odontologist> createOdontologist(@RequestBody Odontologist odontologist){
        return ResponseEntity.status(HttpStatus.CREATED).body(odontologistService.createOdontologist(odontologist));
    }
    @PutMapping
    public ResponseEntity<String> updateOdontologist(@RequestBody Odontologist odontologist){
        Optional<Odontologist> odontologist1 = odontologistService.readId(odontologist.getId());
        if(odontologist1.isPresent()){
            odontologistService.update(odontologist);
            return ResponseEntity.ok("{\"message\":\"odontologist updated\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologist> serachId(@PathVariable Integer id){
        Optional<Odontologist> odontologist = odontologistService.readId(id);
        if (odontologist.isPresent()){
            Odontologist odontologist1 = odontologist.get();
            return ResponseEntity.ok(odontologist1);
        } else
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologist(@PathVariable Integer id){
        Optional<Odontologist> odontologist = odontologistService.readId(id);
        if (odontologist.isPresent()){
            odontologistService.delete(id);
            return ResponseEntity.ok("{\"message\":\"odontologist deleted\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Odontologist>> searchAll(){
        return ResponseEntity.ok(odontologistService.readAll());
    }
}

package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.model.Patient;
import com.dentalclinic.clinic.service.IPatientService;
import com.dentalclinic.clinic.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    public IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> createPatien(@RequestBody Patient patient){
        Patient patient1 = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient1);
    }
    @GetMapping
    public ResponseEntity<List<Patient>> readAll(){
         patientService.readAll();
         return ResponseEntity.ok(patientService.readAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> readById(@PathVariable Integer id){
        Patient patient = patientService.readId(id);
        if (patient != null){
            return ResponseEntity.ok(patient);
        }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping
    public ResponseEntity<String> updatePatient(@RequestBody Patient patient){
        patientService.update(patient);
        return ResponseEntity.ok("Updated patient");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id){
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted");
    }
}

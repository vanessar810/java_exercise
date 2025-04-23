package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.model.Appointment;
import com.dentalclinic.clinic.service.IAppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService iAppointmentService) {
        this.appointmentService = iAppointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){
        Appointment appointment1 = appointmentService.create(appointment);
        if (appointment1 == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(appointment1);
        }
    }
    @GetMapping
    public ResponseEntity<List<Appointment>> readAllAppointments(){
        return ResponseEntity.ok(appointmentService.readAll());
    }
    @PutMapping
    public ResponseEntity<String> updateAppointment(@RequestBody Appointment appointment){
        appointmentService.update(appointment);
        return ResponseEntity.ok("Appointment updated");
    }
}

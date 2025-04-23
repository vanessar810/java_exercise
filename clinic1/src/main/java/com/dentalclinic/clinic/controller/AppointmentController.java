package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.Dto.request.AppointmentRequestDto;
import com.dentalclinic.clinic.Dto.response.AppointmentResponseDto;
import com.dentalclinic.clinic.entity.Appointment;
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
    public ResponseEntity<AppointmentResponseDto> createAppointment(@RequestBody AppointmentRequestDto appointment){
        AppointmentResponseDto appointment1 = appointmentService.create(appointment);
        if (appointment1 == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(appointment1);
        }
    }
    @GetMapping
    public ResponseEntity<List<AppointmentResponseDto>> readAllAppointments(){
        return ResponseEntity.ok(appointmentService.readAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable Integer id, @RequestBody AppointmentRequestDto appointment){
        appointmentService.update(id, appointment);
        return ResponseEntity.ok("Appointment updated");
    }
}

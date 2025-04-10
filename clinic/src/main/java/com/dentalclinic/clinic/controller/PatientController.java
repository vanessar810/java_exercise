package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.model.Patient;
import com.dentalclinic.clinic.service.IPatientService;
import com.dentalclinic.clinic.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PatientController {
    private IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/searchId")
    public  String serachId(Model model, @RequestParam Integer id){
        Patient patient = patientService.readId(id);
        model.addAttribute("name",patient.getName());
        model.addAttribute("lastname",patient.getLastname());
        return "index";
    }
}

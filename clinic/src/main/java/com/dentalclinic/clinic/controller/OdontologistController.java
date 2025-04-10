package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.model.Odontologist;
import com.dentalclinic.clinic.model.Patient;
import com.dentalclinic.clinic.service.IOdontologistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OdontologistController {
    private IOdontologistService odontologistService;

    public OdontologistController(IOdontologistService odontologistService) {
        this.odontologistService = odontologistService;
    }
    @GetMapping("/search")
    public  String serachId(Model model, @RequestParam Integer id){
        Odontologist odontologist = odontologistService.readId(id);
        model.addAttribute("name",odontologist.getName());
        model.addAttribute("lastname",odontologist.getLastname());
        return "index";
    }
}

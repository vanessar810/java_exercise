package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.model.Odontologist;
import com.dentalclinic.clinic.model.Patient;

import java.util.List;

public interface IOdontologistService {
    Odontologist createOdontologist(Odontologist odontologist);
    Odontologist readId(Integer id);
    List<Odontologist> readAll();
    void update(Odontologist odontologist);
    void delete(Integer id);
}

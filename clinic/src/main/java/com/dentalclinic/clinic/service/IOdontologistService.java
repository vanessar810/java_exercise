package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.model.Odontologist;

import java.util.List;

public interface IOdontologistService {
    Odontologist createOdontologist(Odontologist odontologist);
    Odontologist readId(Integer id);
    List<Odontologist> readAll();
}

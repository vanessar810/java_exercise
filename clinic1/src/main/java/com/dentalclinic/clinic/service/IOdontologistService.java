package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.entity.Odontologist;

import java.util.List;
import java.util.Optional;

public interface IOdontologistService {
    Odontologist createOdontologist(Odontologist odontologist);
    Optional<Odontologist> readId(Integer id);
    List<Odontologist> readAll();
    void update(Odontologist odontologist);
    void delete(Integer id);
    // HQL methods
    List<Odontologist> searchByLastname (String lastname);
    List<Odontologist> findByNameLike (String name);
}

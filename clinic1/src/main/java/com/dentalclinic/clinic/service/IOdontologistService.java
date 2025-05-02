package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.entity.Odontologist;
import com.dentalclinic.clinic.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologistService {
    Odontologist createOdontologist(Odontologist odontologist);
    Optional<Odontologist> readId(Integer id) throws ResourceNotFoundException;
    List<Odontologist> readAll();
    void update(Odontologist odontologist) throws ResourceNotFoundException;
    void delete(Integer id) throws ResourceNotFoundException;
    // HQL methods
    List<Odontologist> searchByLastname (String lastname) throws ResourceNotFoundException;
    List<Odontologist> findByNameLike (String name);

    Odontologist addSpeciality(Integer idOdontologist, Integer idSpeciality) throws ResourceNotFoundException;
}

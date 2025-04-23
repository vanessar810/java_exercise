package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
     Patient createPatient(Patient patient);
     Optional<Patient> readId(Integer id);
     List<Patient> readAll();
     void update(Patient patient);
     void delete(Integer id);
}

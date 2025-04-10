package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.model.Patient;

import java.util.List;

public interface IPatientService {
     Patient createPatient(Patient patient);
     Patient readId(Integer id);
     List<Patient> readAll();
}

package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.entity.Patient;
import com.dentalclinic.clinic.repository.IPatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService{
    private IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }
    public Optional<Patient> readId(Integer id){
        return  patientRepository.findById(id);
    }
    public List<Patient> readAll(){
        return patientRepository.findAll();
    }

    @Override
    public void update(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void delete(Integer id) {
        patientRepository.deleteById(id);
    }

}

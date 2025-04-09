package com.dentalclinic.service;

import com.dentalclinic.dao.IDao;
import com.dentalclinic.model.Patient;

import java.util.List;

public class PatientService {
    private IDao<Patient> patientIDao;

    public PatientService(IDao<Patient> patientIDao) {
        this.patientIDao = patientIDao;
    }
    public Patient createPatient(Patient patient){
        return patientIDao.create(patient);
    }
    public Patient readId(Integer id){
        return  patientIDao.readbyId(id);
    }
    public List<Patient> readAll(){
        return patientIDao.readAll();
    }
}

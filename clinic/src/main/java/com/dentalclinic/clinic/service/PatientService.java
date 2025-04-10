package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.dao.IDao;
import com.dentalclinic.clinic.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService implements IPatientService{
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

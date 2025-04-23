package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.dao.Impl.PatientIDao;
import com.dentalclinic.clinic.model.Address;
import com.dentalclinic.clinic.model.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PatientServiceTest extends DBTestConfig{
    private static PatientService patientService= new PatientService(new PatientIDao());

    @Test
    @DisplayName("Create patient in DB")
    void testPatientInDB(){
        Patient patient = new Patient("Émile","Dubois","10111514", LocalDate.of(2024,10,30),new Address("S. Benoit",15,"Saint-Germain"));
        PatientService patientService = new PatientService(new PatientIDao());
        Patient patientDB = patientService.createPatient(patient);
        assertNotNull(patientDB);
    }
    @Test
    @DisplayName("read patient by id")
    void testPatientId(){
        Integer id =2;
        Patient patientFound = patientService.readId(id);
        assertEquals(id,patientFound.getId());
    }
    @Test
    @DisplayName("read all patient")
    void testReadAllPatients(){
        Patient patient = new Patient("Alphonse","Dupont","121212",LocalDate.of(2025,04,07),
                new Address(" Trois Frères",58,"Montmartre"));
        patientService.createPatient(patient);
        List<Patient>patients = patientService.readAll();
        assertEquals(3,patients.size());
    }
}
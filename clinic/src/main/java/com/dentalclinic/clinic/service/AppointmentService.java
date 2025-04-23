package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.dao.IDao;
import com.dentalclinic.clinic.model.Appointment;
import com.dentalclinic.clinic.model.Odontologist;
import com.dentalclinic.clinic.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentService implements IAppointmentService{
    private IDao<Appointment> appointmentIDao;
    private IDao<Patient> patientIDao;
    private IDao<Odontologist> odontologistIDao;

    public AppointmentService(IDao<Appointment> appointmentIDao, IDao<Patient> patientIDao, IDao<Odontologist> odontologistIDao) {
        this.appointmentIDao = appointmentIDao;
        this.patientIDao = patientIDao;
        this.odontologistIDao = odontologistIDao;
    }

    @Override
    public Appointment create(Appointment appointment) {
        Patient patient = patientIDao.readbyId(appointment.getPatient().getId());
        Odontologist odontologist = odontologistIDao.readbyId(appointment.getOdontologist().getId());
        Appointment appointment1 = new Appointment();
        Appointment appointment2 = null;
        if (patient!=null && odontologist!=null){
            appointment1.setDate(appointment.getDate());
            appointment1.setPatient(patient);
            appointment1.setOdontologist(odontologist);
            appointment2=appointmentIDao.create(appointment1);
        }
        return appointment2;
    }

    @Override
    public Appointment readId(Integer id) {
        return appointmentIDao.readbyId(id);
    }

    @Override
    public List<Appointment> readAll() {
        return appointmentIDao.readAll();
    }

    @Override
    public void update(Appointment appointment) {
        Patient patient = patientIDao.readbyId(appointment.getPatient().getId());
        Odontologist odontologist = odontologistIDao.readbyId(appointment.getOdontologist().getId());
        Appointment appointment1 = new Appointment();
        if (patient!=null && odontologist!=null){
            appointment1.setId(appointment.getId());
            appointment1.setDate(appointment.getDate());
            appointment1.setPatient(patient);
            appointment1.setOdontologist(odontologist);
            appointmentIDao.update(appointment1);
        }
    }

    @Override
    public void delete(Integer id) {
    appointmentIDao.delete(id);
    }
}

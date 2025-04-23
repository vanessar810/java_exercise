package com.dentalclinic.clinic.dao.Impl;

import com.dentalclinic.clinic.dao.IDao;
import com.dentalclinic.clinic.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AppointmentDao implements IDao<Appointment> {

    private static Logger logger = LoggerFactory.getLogger(AppointmentDao.class);
    private List<Appointment> appointments;

    public AppointmentDao(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public Appointment create(Appointment appointment) {
        Integer id = appointments.size() + 1;
        appointment.setId(id);
        appointments.add(appointment);
        logger.info("appointment created: "+appointment);
        return appointment;
    }

    @Override
    public Appointment readbyId(Integer id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                logger.info("Appointment found: " + appointment);
                return appointment;
            }
        }
        logger.info("Appointment not found");
        return null;
    }

    @Override
    public List<Appointment> readAll() {
        return appointments;
    }

    @Override
    public void update(Appointment appointment) {
        for (Appointment a : appointments) {
            if (a.getId().equals(appointment.getId())) {
                a.setDate(appointment.getDate());
                a.setPatient(appointment.getPatient());
                a.setOdontologist(appointment.getOdontologist());
                logger.info("Appointment updated: " + appointment);
                break;
            }
        }
        logger.info("Appointment can't be updated");
    }

    @Override
    public void delete(Integer id) {
        Appointment appointment1 = null;
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment1 = appointment;
                break;
            }
        }
        appointments.remove(appointment1);
        logger.info("appointment deleted");
    }
}
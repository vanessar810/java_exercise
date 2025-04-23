package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.model.Appointment;


import java.util.List;

public interface IAppointmentService {
    Appointment create(Appointment appointment);
    Appointment readId(Integer id);
    List<Appointment> readAll();
    void update(Appointment appointment);
    void delete(Integer id);
}

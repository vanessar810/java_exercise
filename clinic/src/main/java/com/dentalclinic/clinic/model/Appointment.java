package com.dentalclinic.clinic.model;

import java.time.LocalDate;

public class Appointment {
     Integer id;
     LocalDate date;
     Patient patient;
     Odontologist odontologist;

    public Appointment() {
    }

    public Appointment(Integer id, LocalDate date, Patient patient, Odontologist odontologist) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.odontologist = odontologist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Patient getPatient() {
        return patient;
    }

    public Odontologist getOdontologist() {
        return odontologist;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setOdontologist(Odontologist odontologist) {
        this.odontologist = odontologist;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date" +
                "id=" + id +
                ", date=" + date +
                ", patient=" + patient +
                ", odontologist=" + odontologist;
    }
}

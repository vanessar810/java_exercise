package com.dentalclinic.clinic.model;

import java.time.LocalDate;

public class Patient {
    private Integer id;
    private String name;
    private String lastname;
    private String dni;
    private LocalDate inDate;
    private Address address;

    public Patient(String name, String lastname, String dni, LocalDate inDate, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.inDate = inDate;
        this.address = address;
    }

    public Patient(Integer id, String name, String lastname, String dni, LocalDate inDate, Address address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.inDate = inDate;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Patient" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni='" + dni + '\'' +
                ", inDate=" + inDate +
                ", address=" + address;
    }
}

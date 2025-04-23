package com.dentalclinic.clinic.model;

public class Odontologist {
    private Integer id;
    private String name;
    private String lastname;
    private String license;

    public Odontologist() {
    }

    public Odontologist(String name, String lastname, String license) {
        this.name = name;
        this.lastname = lastname;
        this.license = license;
    }

    public Odontologist(Integer id, String name, String lastname, String license) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.license = license;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {this.id = id;}

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLicense() {
        return license;
    }

    @Override
    public String toString() {
        return "Odontologist" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", license='" + license;
    }
}

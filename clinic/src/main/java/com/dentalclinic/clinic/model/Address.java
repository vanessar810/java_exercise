package com.dentalclinic.clinic.model;

public class Address {
    private Integer id;
    private String street;
    private int number;
    private String neighborhood;

    public Address() {
    }

    public Address(String street, int number, String neighborhood) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
    }

    public Address(Integer id, String street, int number, String neighborhood) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    @Override
    public String toString() {
        return "Address" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", neighborhood='" + neighborhood;
    }
}

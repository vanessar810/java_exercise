package com.page.model;

public class Cuenta {
    private Integer id;
    private Integer nroCuenta;
    private String nombre;
    private double saldo;

    public Cuenta(Integer id, Integer nroCuenta, String nombre, double saldo) {
        this.id = id;
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Cuenta(Integer nroCuenta, String nombre, double saldo) {
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Integer getNroCuenta() {
        return nroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta " +
                "nroCuenta=" + nroCuenta +
                ", nombre='" + nombre + '\'' +
                ", saldo=" + saldo;
    }
}

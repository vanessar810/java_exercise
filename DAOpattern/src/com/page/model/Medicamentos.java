package com.page.model;

public class Medicamentos {
    private Integer id;
    private Integer codigo;
    private String nombre;
    private String laboratorio;
    private int cantidad;
    private double precio;

    public Medicamentos(Integer id, Integer codigo, String nombre, String laboratorio, int cantidad, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Medicamentos(Integer codigo, String nombre, String laboratorio, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Medicamentos{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}

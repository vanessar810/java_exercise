package com.pagina.model;

public class Menu {
    private double precioBase;
    private double Especias ;
    private int salsas;
    private double juguetes;

    public Menu(double precioBase, double especias, int salsas, double juguetes) {
        this.precioBase = precioBase;
        Especias = especias;
        this.salsas = salsas;
        this.juguetes = juguetes;
    }

    public double getEspecias() {
        return Especias;
    }

    public int getSalsas() {
        return salsas;
    }

    public double getJuguetes() {
        return juguetes;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}

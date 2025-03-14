package com.pagina.service;

import com.pagina.model.Menu;

public class EmpleadoInfantil extends Empleado{
    @Override
    public double CalcularPrecioVenta(Menu menu) {
        double precioTotal = menu.getPrecioBase()+3* menu.getJuguetes();
        return precioTotal;
    }

    @Override
    public String preparacion(Menu menu) {
        return "Menú Infantil";
    }
}

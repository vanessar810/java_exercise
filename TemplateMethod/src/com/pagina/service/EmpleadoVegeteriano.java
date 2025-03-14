package com.pagina.service;

import com.pagina.model.Menu;

public class EmpleadoVegeteriano extends Empleado{
    @Override
    public double CalcularPrecioVenta(Menu menu) {
        double precioTotal = menu.getPrecioBase()*(1.01*menu.getEspecias())+2* menu.getSalsas();
        return precioTotal;
    }

    @Override
    public String preparacion(Menu menu) {
        return "Menú Vegie";
    }
}

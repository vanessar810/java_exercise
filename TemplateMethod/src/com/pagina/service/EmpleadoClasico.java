package com.pagina.service;

import com.pagina.model.Menu;

public class EmpleadoClasico extends Empleado{
    @Override
    public double CalcularPrecioVenta(Menu menu) {
        return menu.getPrecioBase();
    }

    @Override
    public String preparacion(Menu menu) {
        return "Menú Clasico";
    }
}

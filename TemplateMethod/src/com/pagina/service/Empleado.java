package com.pagina.service;

import com.pagina.model.Menu;

public abstract class Empleado {

public String preparacionMenu(Menu menu){
    String preparacion = preparacion(menu);
    double precio= CalcularPrecioVenta(menu);
    return "El menu en preparación es: "+ preparacion+" y tiene un valor de: "+precio;
}
    public abstract double CalcularPrecioVenta(Menu menu);
    public abstract String preparacion(Menu menu);
}

package com.pagina.test;
import com.pagina.model.Menu;
import com.pagina.service.Empleado;
import com.pagina.service.EmpleadoClasico;
import com.pagina.service.EmpleadoInfantil;
import com.pagina.service.EmpleadoVegeteriano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {
    @Test
    @DisplayName("MenuClasico")
    void testMenuClasico(){
        Menu menuClasico1 = new Menu(20,1,1,1);
        EmpleadoClasico empleadoClasico = new EmpleadoClasico();

        String respuestaEsperada = "El menu en preparación es: Menú Clasico y tiene un valor de: 20.0";
        String respuestaObtenida = empleadoClasico.preparacionMenu(menuClasico1);
        assertEquals(respuestaEsperada,respuestaObtenida);
    }
    @Test
    @DisplayName("MenuVegie")
    void testMenuVegie(){
        Menu menuVegie1 = new Menu(15,5,2,0);
        EmpleadoVegeteriano empleadoVegie = new EmpleadoVegeteriano();
        String respuestaEsperada = "El menu en preparación es: Menú Vegie y tiene un valor de: 79.75";
        String respuestaObtenida = empleadoVegie.preparacionMenu(menuVegie1);
        assertEquals(respuestaEsperada,respuestaObtenida);
    }
    @Test
    @DisplayName("MenuInfantil")
    void testMenuInfantil(){
        Menu menuInfantil = new Menu(15,0,0,5);
        EmpleadoInfantil empleadoInfantil = new EmpleadoInfantil();
        String respuestaEsperada = "El menu en preparación es: Menú Infantil y tiene un valor de: 30.0";
        String respuestaObtenida = empleadoInfantil.preparacionMenu(menuInfantil);
        assertEquals(respuestaEsperada,respuestaObtenida);
    }
}

package com.pagina.test;

import com.pagina.model.Articulo;
import com.pagina.service.CompruebaCalidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalistaCalidadTest {
    @Test
    @DisplayName("Testear producto que pase todos los controles")
    void test1(){
        Articulo articulo = new Articulo("zapatos",1300,1200,"Sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String analisis = compruebaCalidad.CompruebaCalidad1(articulo);
        assertEquals("el articulo paso calidad",analisis);
    }
    @Test
    @DisplayName("Testear producto por peso")
    void test2(){
        Articulo articulo = new Articulo("zapatos",1300,1500,"Sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String analisis = compruebaCalidad.CompruebaCalidad1(articulo);
        assertEquals("NO paso calidad peso",analisis);
    }
    @Test
    @DisplayName("Testear producto por lote")
    void test3(){
        Articulo articulo = new Articulo("zapatos",900,1500,"Sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String analisis = compruebaCalidad.CompruebaCalidad1(articulo);
        assertEquals("NO paso calidad Lote",analisis);
    }
    @Test
    @DisplayName("Testear producto por envase")
    void test4(){
        Articulo articulo = new Articulo("zapatos",1300,1200,"malo");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String analisis = compruebaCalidad.CompruebaCalidad1(articulo);
        assertEquals("el articulo no cumple calidad de envase",analisis);
    }
}

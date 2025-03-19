package com.pagina.service;

import com.pagina.model.Articulo;

public class CompruebaCalidad {
    public String CompruebaCalidad1(Articulo articulo){
        AnalistaCalidad analistaCalidad1 = new CompruebaLote();
        AnalistaCalidad analistaCalidad2 = new CompruebaPeso();
        AnalistaCalidad analistaCalidad3 = new CompruebaEnvase();
        analistaCalidad1.setSiguiente(analistaCalidad2);
        analistaCalidad2.setSiguiente(analistaCalidad3);
        return analistaCalidad1.compruebaCalidad(articulo);
    }
}

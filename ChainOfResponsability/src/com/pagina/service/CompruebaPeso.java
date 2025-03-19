package com.pagina.service;

import com.pagina.model.Articulo;

public class CompruebaPeso extends AnalistaCalidad{
    @Override
    public String compruebaCalidad(Articulo articulo) {
        if (articulo.getPeso() >= 1200 && articulo.getPeso()<=1300){
            return  getSiguiente().compruebaCalidad(articulo);
        }
        return "NO paso calidad peso";
    }
}

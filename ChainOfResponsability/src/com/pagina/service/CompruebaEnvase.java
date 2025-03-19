package com.pagina.service;

import com.pagina.model.Articulo;

public class CompruebaEnvase extends AnalistaCalidad{

    @Override
    public String compruebaCalidad(Articulo articulo) {
       if (articulo.getEnvase().equalsIgnoreCase("sano")|| articulo.getEnvase().equalsIgnoreCase("casi sano")){
           return "el articulo paso calidad";
       }
        return "el articulo no cumple calidad de envase";
    }
}

package com.pagina.service;

import com.pagina.model.Articulo;

public class CompruebaLote extends AnalistaCalidad{
    @Override
    public String compruebaCalidad(Articulo articulo) {
        if (articulo.getLote() >= 1000 && articulo.getLote()<=2000){
            return  getSiguiente().compruebaCalidad(articulo);
        }
         return  "NO paso calidad Lote";
    }
}

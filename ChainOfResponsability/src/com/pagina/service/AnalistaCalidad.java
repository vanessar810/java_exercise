package com.pagina.service;

import com.pagina.model.Articulo;

public abstract class AnalistaCalidad {
    private AnalistaCalidad siguiente;

    public AnalistaCalidad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(AnalistaCalidad siguiente) {
        this.siguiente = siguiente;
    }
 public abstract String compruebaCalidad(Articulo articulo);
}

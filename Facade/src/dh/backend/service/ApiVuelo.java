package dh.backend.service;

import dh.backend.model.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiVuelo {
    List<Vuelo> vuelos;

    public ApiVuelo() {
        vuelos = new ArrayList<>();
        cargarVuelos();
    }
    public boolean buscarVuelos(String origen, String destino, LocalDate fechaIngreso, LocalDate fechaEgreso){
        boolean response = false;
        Vuelo vueloBuscar = new Vuelo(origen, destino, fechaIngreso,fechaEgreso);
        for (Vuelo vuelo: vuelos){
            if (vuelo.equals(vueloBuscar)){
                System.out.println("vuelo disponible");
                response = true;
            }
        }
        return response;
    }
    public void cargarVuelos(){
        vuelos.add(new Vuelo("Medellin","Berlin", LocalDate.of(2025,03,01),LocalDate.of(2025,03,29) ));
        vuelos.add(new Vuelo("Madrid","Paris", LocalDate.of(2025,04,06),LocalDate.of(2025,04,21) ));
    }
}

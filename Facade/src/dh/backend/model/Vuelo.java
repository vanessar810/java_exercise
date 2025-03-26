package dh.backend.model;

import java.time.LocalDate;
import java.util.Objects;

public class Vuelo {
    private String origen;
    private String Destino;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;

    public Vuelo(String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.origen = origen;
        Destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vuelo vuelo)) return false;
        return Objects.equals(origen, vuelo.origen) && Objects.equals(Destino, vuelo.Destino) && Objects.equals(fechaSalida, vuelo.fechaSalida) && Objects.equals(fechaLlegada, vuelo.fechaLlegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origen, Destino, fechaSalida, fechaLlegada);
    }
}

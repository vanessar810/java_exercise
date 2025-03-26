package dh.backend.model;

import java.time.LocalDate;
import java.util.Objects;

public class Hotel {
    private String Ciudad;

    private LocalDate fechaLlegada;
    private LocalDate fechaSalida;

    public Hotel(String ciudad, LocalDate fechaLlegada,LocalDate fechaSalida) {
        Ciudad = ciudad;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel hotel)) return false;
        return Objects.equals(Ciudad, hotel.Ciudad) && Objects.equals(fechaLlegada, hotel.fechaLlegada) && Objects.equals(fechaSalida, hotel.fechaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Ciudad, fechaLlegada, fechaSalida);
    }
}

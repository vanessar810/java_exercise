package dh.backend.service;

import java.time.LocalDate;

public interface IFacadeService {
    boolean SearchService(String origin, String destino, LocalDate fechaInicio, LocalDate fechaFin);
}

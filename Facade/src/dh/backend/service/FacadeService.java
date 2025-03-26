package dh.backend.service;

import java.time.LocalDate;

public class FacadeService implements IFacadeService{
    ApiHotel apiHotel;
    ApiVuelo apiVuelo;

    public FacadeService() {
        apiHotel = new ApiHotel();
        apiVuelo = new ApiVuelo();
    }

    @Override
    public boolean SearchService(String origin, String destino, LocalDate fechaInicio, LocalDate fechaFin) {
       boolean responseHotel = apiHotel.buscarHotel(destino,fechaInicio,fechaFin);
        boolean responseVuelo = apiVuelo.buscarVuelos(origin,destino,fechaInicio,fechaFin);
        return responseHotel && responseVuelo;
    }
}

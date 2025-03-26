package dh.backend.service;

import dh.backend.model.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiHotel {
 List<Hotel> hotels;
 public ApiHotel(){
     hotels = new ArrayList<>();
     cargarHoteles();
 }
 public boolean buscarHotel(String Ciudad, LocalDate fechaLlegada, LocalDate fechaSalida){
     boolean response = false;
     Hotel hotelBuscar = new Hotel(Ciudad, fechaLlegada, fechaSalida);
     for (Hotel hotel: hotels){
         if (hotel.equals(hotelBuscar)){
             System.out.println("Hotel disponible");
             response = true;
         }
     }
     return response;
 }
 public void cargarHoteles(){
     hotels.add(new Hotel("Berlin",LocalDate.of(2025,03,01),LocalDate.of(2025,03,29)));
     hotels.add(new Hotel("Paris",LocalDate.of(2025,03,01),LocalDate.of(2025,03,29)));
 }
}

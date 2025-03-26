package dh.backend.test;

import dh.backend.service.FacadeService;
import dh.backend.service.IFacadeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IFacadeServiceTest {
    @Test
    @DisplayName("Testear que exista el servicio")
    void existeServicio(){
        IFacadeService facadeService = new FacadeService();
        boolean response = facadeService.SearchService("Medellin","Berlin", LocalDate.of(2025,03,01),LocalDate.of(2025,03,29));
        assertTrue(response);
    }
}

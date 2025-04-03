package com.page.test;

import com.page.dao.IDao;
import com.page.dao.impl.MedicamentoIDaoImpl;
import com.page.model.Medicamentos;
import com.page.service.MedicamentoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicamentosServiceTest {
    @BeforeAll
    static void createTables() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/patronDAO;INIT=RUNSCRIPT FROM 'create.sql'", "", "");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
    public static Logger logger = Logger.getLogger(MedicamentosServiceTest.class);
    @Test
    @DisplayName("Create medicine in DB")
    void testMedicineInDB(){
        Medicamentos medicamentos = new Medicamentos(1234, "ASPIRINA","BAGO", 30, 10);
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoIDaoImpl());
        Medicamentos medicamentoCreado = medicamentoService.registerMedicine(medicamentos);
        assertNotNull(medicamentoCreado);

    }
    @Test
    @DisplayName("Return a medicine with name")
    void ReturnMedicineWithName(){
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoIDaoImpl());
        String name = "IBUPROFENO";
        Medicamentos medicineFound = medicamentoService.searchName(name);
        assertEquals(name,medicineFound.getNombre());
    }
    @Test
    @DisplayName("verify only created medicines")
    void ReturnOnlyRegistered(){
        MedicamentoService medicamentoService= new MedicamentoService(new MedicamentoIDaoImpl());
        String name ="ARIPIPRAZOL";
        Medicamentos medicamentosFound = medicamentoService.searchName(name);
        assertNull(medicamentosFound);
    }
    @Test
    @DisplayName("verify all medicines")
    void testAllMedicines(){
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoIDaoImpl());
        List<Medicamentos> registeredMedicines = medicamentoService.searchAll();
        assertEquals(2,registeredMedicines.size());
    }

}

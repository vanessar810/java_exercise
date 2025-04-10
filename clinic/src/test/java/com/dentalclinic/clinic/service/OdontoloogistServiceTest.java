package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.dao.Impl.OdontologistIDao;
import com.dentalclinic.clinic.model.Odontologist;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontoloogistServiceTest {
    private static Logger logger = LoggerFactory.getLogger(OdontoloogistServiceTest.class);
    private static OdontologistService odontologistService = new OdontologistService(new OdontologistIDao());
    @BeforeAll
    static void setUpDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
                 Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE DATABASE IF NOT EXISTS db_clinic_250409");
            }
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_clinic_250409", "root", "root");
                 Statement stmt = conn.createStatement()) {
                String sql = new String(Files.readAllBytes(Paths.get("create.sql")));
                String[] sqlStatements = sql.split(";");
                for (String statement : sqlStatements) {
                    statement = statement.trim();
                    if (!statement.isEmpty() && !statement.toLowerCase().startsWith("create database") && !statement.toLowerCase().startsWith("use")) {
                        System.out.println("executing: " + statement);
                        stmt.execute(statement);
                    }
                }
            }

        }  catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
    @Test
    @DisplayName("Create odont in DB")
    void testOdontnDB(){
        Odontologist odontologist = new Odontologist("Edmé","Lambert","10002");
        OdontologistService odontologistService = new OdontologistService(new OdontologistIDao());
        Odontologist odotDB = odontologistService.createOdontologist(odontologist);
        assertNotNull(odotDB);
    }
    @Test
    @DisplayName("search odont by Id")
    void testOdontId(){
     Integer id = 2;
     Odontologist odontFound = odontologistService.readId(id);
     assertEquals(id,odontFound.getId());
    }
    @Test
    @DisplayName("search all odont")
    void testSearchallOdontDB(){
        Odontologist odontologist = new Odontologist("Étienne","Dubois","10003");
        odontologistService.createOdontologist(odontologist);
        List<Odontologist>odontologists = odontologistService.readAll();
        assertEquals(2,odontologists.size());
    }

}
package service.test;

import com.dentalclinic.dao.Impl.PatientIDao;
import com.dentalclinic.model.Address;
import com.dentalclinic.model.Patient;
import com.dentalclinic.service.PatientService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {
    private static Logger logger = Logger.getLogger(PatientServiceTest.class);
    private static PatientService patientService= new PatientService(new PatientIDao());
    @BeforeAll
    static void createTables() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
                 Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE DATABASE IF NOT EXISTS db_clinic_0409");
            }
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_clinic_0409", "root", "root");
                 Statement stmt = conn.createStatement()) {
                String sql = new String(Files.readAllBytes(Paths.get("src/test/java/service/test/resources/create.sql")));
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
    @DisplayName("Create patient in DB")
    void testPatientInDB(){
        Patient patient = new Patient("Émile","Dubois","10111514", LocalDate.of(2024,10,30),new Address("S. Benoit",15,"Saint-Germain"));
        PatientService patientService = new PatientService(new PatientIDao());
        Patient patientDB = patientService.createPatient(patient);
        assertNotNull(patientDB);
    }
    @Test
    @DisplayName("read patient by id")
    void testPatientId(){
        Integer id =2;
        Patient patientFound = patientService.readId(id);
        assertEquals(id,patientFound.getId());
    }
    @Test
    @DisplayName("read all patient")
    void testReadAllPatients(){
        Patient patient = new Patient("Alphonse","Dupont","121212",LocalDate.of(2025,04,07),
                new Address(" Trois Frères",58,"Montmartre"));
        patientService.createPatient(patient);
        List<Patient>patients = patientService.readAll();
        assertEquals(3,patients.size());
    }

}
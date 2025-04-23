package com.dentalclinic.clinic.service;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBTestConfig {
    private static Logger logger = LoggerFactory.getLogger(OdontoloogistServiceTest.class);
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
}

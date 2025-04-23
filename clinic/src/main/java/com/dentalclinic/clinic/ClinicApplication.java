package com.dentalclinic.clinic;

import com.dentalclinic.clinic.db.MySQLConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootApplication
public class ClinicApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClinicApplication.class, args);
	}

}

package com.dentalclinic.clinic.dao.Impl;

import com.dentalclinic.clinic.dao.IDao;
import com.dentalclinic.clinic.db.MySQLConnection;
import com.dentalclinic.clinic.model.Address;
import com.dentalclinic.clinic.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class PatientIDao implements IDao<Patient> {
    private static Logger logger = LoggerFactory.getLogger(PatientIDao.class);
    private static String SQL_INSERT = "insert into patients values (default,?,?,?,?,?)";
    private static String SQL_SELECT_ID = "select * from patients where id = ?";
    public static String SQL_SELECT_ALL = "select * from patients";
    @Override
    public Patient create(Patient patient) {
        Connection connection = null;
        AddressIDao addressIDao = new AddressIDao();
        Patient patient1 = null;
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            Address addressSaved = addressIDao.create(patient.getAddress());
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,patient.getName());
            preparedStatement.setString(2,patient.getLastname());
            preparedStatement.setString(3,patient.getDni());
            preparedStatement.setDate(4, Date.valueOf(patient.getInDate()));
            preparedStatement.setInt(5,addressSaved.getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                patient1 = new Patient(id,patient.getName(),patient.getLastname(),patient.getDni(),patient.getInDate(),addressSaved);
            }
            logger.info("Patient saved: "+patient1);
            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            logger.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return patient1;
    }

    @Override
    public Patient readbyId(Integer id) {
      Connection connection = null;
      Patient patient = null;
      AddressIDao addressIDao = new AddressIDao();
      try {
        connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
         while (resultSet.next()){
             Integer idReturned = resultSet.getInt(1);
             String name = resultSet.getString(2);
             String lastname = resultSet.getString(3);
             String dni = resultSet.getString(4);
             LocalDate date = resultSet.getDate(5).toLocalDate();
             Integer idAddress = resultSet.getInt(6);
             Address addressFound = addressIDao.readbyId(idAddress);
             patient = new Patient(idReturned,name,lastname,dni,date,addressFound);
         }
         logger.info("Patient found: "+patient);
      }catch (Exception e){
          if(connection!=null){
              try {
                  connection.rollback();
              } catch (SQLException ex) {
                  logger.info(ex.getMessage());
                  ex.printStackTrace();
              }
          }
          logger.info(e.getMessage());
          e.printStackTrace();
      }finally {
          try {
              connection.close();
          } catch (SQLException e) {
              logger.info(e.getMessage());
              e.printStackTrace();
          }
      }
        return patient;
    }

    @Override
    public List<Patient> readAll() {
        List<Patient> patients = new ArrayList<>();
        AddressIDao addressIDao = new AddressIDao();
        Connection connection = null;
        try {
            connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Integer idReturned = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String dni = resultSet.getString(4);
                LocalDate date = resultSet.getDate(5).toLocalDate();
                Integer idAddress = resultSet.getInt(6);
                Address addressFound = addressIDao.readbyId(idAddress);
                Patient patient = new Patient(idReturned, name, lastname, dni, date, addressFound);
                logger.info("Patient List: " + patient);
                patients.add(patient);
            }
        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            logger.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.info(e.getMessage());
                e.printStackTrace();
            }
        }

        return patients;
    }
}

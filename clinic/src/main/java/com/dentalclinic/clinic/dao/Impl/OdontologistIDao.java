package com.dentalclinic.clinic.dao.Impl;

import com.dentalclinic.clinic.dao.IDao;
import com.dentalclinic.clinic.db.MySQLConnection;
import com.dentalclinic.clinic.model.Odontologist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class OdontologistIDao implements IDao<Odontologist> {
    private static final Logger logger = LoggerFactory.getLogger(OdontologistIDao.class);
    private static final String INSERT = "INSERT INTO ODONTOLOGISTS VALUES (DEFAULT,?,?,?)";
    private static final String SQL_SELECT_ID = "select * from odontologists where id = ?";
    public static final String SQL_SELECT_ALL = "select * from odontologists";
    public static final String SQL_UPDATE = "update odontologists set name = ?, lastname = ?, license = ? where id=?";
    public static final String SQL_DELETE = "delete from odontologists where id =?";



    @Override
    public Odontologist create(Odontologist odontologist) {
        Connection connection = null;
        Odontologist odontologist1 = null;
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,odontologist.getName());
            preparedStatement.setString(2,odontologist.getLastname());
            preparedStatement.setString(3,odontologist.getLicense());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                odontologist.setId(id);
                //id = odontologist.setId(resultSet.getInt(1));
                System.out.println("id generado: "+id);
                odontologist1 = odontologist;
            }
            logger.info("Odontologist created: "+ odontologist1);
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
        return odontologist1;
    }

    @Override
    public Odontologist readbyId(Integer id) {
        Connection connection = null;
        Odontologist odontologist = null;
        try {
            connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer idReturned = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String license = resultSet.getString(4);
                odontologist = new Odontologist(idReturned, name, lastname, license);
            }
            logger.info("Odontologist found: "+odontologist);
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
        return odontologist;
    }

    @Override
    public List<Odontologist> readAll() {
        List<Odontologist> odontologists = new ArrayList<>();
        Connection connection = null;
        try{
            connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()){
                Integer idReturned = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String license = resultSet.getString(4);
                Odontologist odontologist = new Odontologist(idReturned, name, lastname, license);
                logger.info("Odontologist List: "+odontologist);
                odontologists.add(odontologist);
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
        return odontologists;
    }

    @Override
    public void update(Odontologist odontologist) {
            Connection connection = null;
            Odontologist odontologist1 = null;
            try {
                connection = MySQLConnection.getConnection();
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
                preparedStatement.setString(1,odontologist.getName());
                preparedStatement.setString(2,odontologist.getLastname());
                preparedStatement.setString(3,odontologist.getLicense());
                preparedStatement.executeUpdate();
                logger.info("Odontologist updated: "+ odontologist1);
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
        }

    @Override
    public void delete(Integer id) {
            Connection connection = null;
            try {
                connection = MySQLConnection.getConnection();
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                logger.info("Odontologist created: ");
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
    }
}

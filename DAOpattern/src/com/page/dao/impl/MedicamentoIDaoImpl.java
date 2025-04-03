package com.page.dao.impl;

import com.page.dao.IDao;
import com.page.db.H2Connection;
import com.page.model.Medicamentos;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MedicamentoIDaoImpl implements IDao<Medicamentos> {

    public static Logger logger = Logger.getLogger(MedicamentoIDaoImpl.class);
    public static String SQL_INSERT ="insert into Medicines values (default, ?,?,?,?,?)";
    public static String SQL_SELECT ="select * from Medicines where nombre=?";
    public static String SQL_SELECT_ID ="select * from Medicines where id=?";
    public static String SQL_SELECT_ALL ="select * from Medicines";

    @Override
    public Medicamentos register(Medicamentos medicamentos) {
        Connection connection = null;
        Medicamentos medicamentos1= null;
        try {
          connection = H2Connection.getConnection();
          connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,medicamentos.getCodigo());
            preparedStatement.setString(2,medicamentos.getNombre());
            preparedStatement.setString(3,medicamentos.getLaboratorio());
            preparedStatement.setInt(4,medicamentos.getCantidad());
            preparedStatement.setDouble(5,medicamentos.getPrecio());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                medicamentos1 = new Medicamentos(id, medicamentos.getCodigo(),medicamentos.getNombre(),
                        medicamentos.getLaboratorio(), medicamentos.getCantidad(), medicamentos.getPrecio());
            }
            logger.info("Medicamento creado: "+medicamentos1);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.error(ex.getMessage());
                }
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return medicamentos1;
        }

    @Override
    public Medicamentos searchField(String field) {
        Connection connection = null;
        Medicamentos medicamentos1 = null;
        try {
           connection = H2Connection.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
           preparedStatement.setString(1,field.toUpperCase());
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               Integer id = resultSet.getInt(1);
               Integer codigo = resultSet.getInt(2);
               String nombre = resultSet.getString(3);
               String lab = resultSet.getString(4);
               int cantidad = resultSet.getInt(5);
               double precio = resultSet.getDouble(6);
               medicamentos1 = new Medicamentos(id,codigo,nombre,lab,cantidad,precio);
           }
            logger.info("el medicamento encontrado es: "+medicamentos1);
        } catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return medicamentos1;
    }

    @Override
    public Medicamentos searchID(Integer id) {
        Connection connection = null;
        Medicamentos medicamentos1 = null;
        try{
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            Integer id1 = resultSet.getInt(1);
            Integer code = resultSet.getInt(2);
            String nombre = resultSet.getString(3);
            String lab = resultSet.getString(4);
            int cantidad = resultSet.getInt(5);
            double precio = resultSet.getDouble(6);
            medicamentos1 = new Medicamentos(id1,code,nombre,lab,cantidad,precio);
            }
            logger.info("id corresponde al medicamento: "+medicamentos1);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return medicamentos1;
    }

    @Override
    public List<Medicamentos> searchAll() {
        Connection connection = null;
        Medicamentos medicamentos = null;
        List<Medicamentos> medicamentos1 = new ArrayList<>();
        try {
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()){
                medicamentos = new Medicamentos(resultSet.getInt(1),resultSet.getInt(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getDouble(6));
                logger.info("Medicamentos: "+medicamentos);
                medicamentos1.add(medicamentos);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return medicamentos1;
    }
}


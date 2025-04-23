package com.dentalclinic.clinic.dao.Impl;

import com.dentalclinic.clinic.dao.IDao;
import com.dentalclinic.clinic.db.MySQLConnection;
import com.dentalclinic.clinic.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

public class AddressIDao implements IDao<Address> {
    private static Logger logger = LoggerFactory.getLogger(AddressIDao.class);
    private static String SQL_INSERT = "insert into addresses values (default,?,?,?)";
    private static String SQL_SELECT_ID = "select * from addresses where id = ?";
    public static final String SQL_UPDATE = "update addresses set street = ?, number = ?, neighborhood = ? where id=?";
    public static final String SQL_DELETE = "delete from addresses where id =?";

    @Override
    public Address create(Address address) {
        Connection connection = null;
        Address address1 = null;
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,address.getStreet());
            preparedStatement.setInt(2,address.getNumber());
            preparedStatement.setString(3,address.getNeighborhood());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                address1 = new Address(id, address.getStreet(), address.getNumber(), address.getNeighborhood());
            }
             logger.info("persisted patient: "+address1);
            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e){
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
        return address1;
    }

    @Override
    public Address readbyId(Integer id) {
     Connection connection = null;
     Address address1 = null;
try {
    connection = MySQLConnection.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
    preparedStatement.setInt(1,id);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()){
        Integer idFound = resultSet.getInt(1);
        String street = resultSet.getString(2);
        int number = resultSet.getInt(3);
        String neighborhood = resultSet.getString(4);
        address1 = new Address(idFound,street,number,neighborhood);
    }
logger.info("Found address: "+address1);

}catch (Exception e){
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
        return address1;
    }

    @Override
    public List<Address> readAll() {
        return null;
    }

    @Override
    public void update(Address address) {
        Connection connection = null;
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,address.getStreet());
            preparedStatement.setInt(2,address.getNumber());
            preparedStatement.setString(3,address.getNeighborhood());
            preparedStatement.setInt(4,address.getId());
            preparedStatement.executeUpdate();

            logger.info("updated patient address:");
            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e){
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
    }}

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            logger.info("deleted patient address");
            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e){
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

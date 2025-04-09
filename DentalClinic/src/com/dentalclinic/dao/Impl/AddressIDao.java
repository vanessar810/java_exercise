package com.dentalclinic.dao.Impl;

import com.dentalclinic.dao.IDao;
import com.dentalclinic.db.MySQLConnection;
import com.dentalclinic.model.Address;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class AddressIDao implements IDao<Address> {
    private static Logger logger = Logger.getLogger(AddressIDao.class);
    private static String SQL_INSERT = "insert into addresses values (default,?,?,?)";
    private static String SQL_SELECT_ID = "select * from addresses where id = ?";

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
}

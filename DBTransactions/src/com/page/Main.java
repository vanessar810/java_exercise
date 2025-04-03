package com.page;

import com.page.db.H2Connection;
import com.page.model.Cuenta;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class);
    public static String SQL_CREATE = "Drop table if exists Cuentas;" +
            "create table Cuentas(id int auto_increment primary key, nrocuenta int not null," +
            "nombre varchar(50) not null, saldo numeric(7,2) not null)";
    public static String SQL_INSERT = "insert into Cuentas values(default,?,?,?)";
    public static String SQL_SELECT = "select * from Cuentas";
    public static String SQL_UPDATE = "update Cuentas set saldo=? where nrocuenta=?";

    public static void main(String[] args) {
        Connection connection = null;
        Cuenta cuenta = new Cuenta(1012, "Sara", 5000);
        Cuenta cuentaDesdeDB = null;
        try {
         connection = H2Connection.getConnection();
         //Crear tabla
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);
         //Inserción datos
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, cuenta.getNroCuenta());
            preparedStatement.setString(2, cuenta.getNombre());
            preparedStatement.setDouble(3, cuenta.getSaldo());
            preparedStatement.executeUpdate();

            //mostrar datos desde DB
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                Integer nroCuenta = resultSet.getInt(2);
                String nombre = resultSet.getString(3);
                double saldo = resultSet.getDouble(4);
                cuentaDesdeDB = new Cuenta(id, nroCuenta, nombre, saldo);
            }
                logger.info("Información cuenta: "+cuentaDesdeDB);
                //Update de cuenta
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setDouble(1,cuenta.getSaldo());
            preparedStatement.setInt(2,cuenta.getNroCuenta());
            preparedStatement.executeUpdate();
            cuenta.setSaldo(cuenta.getSaldo()+10);
            //mostrar datos desde DB
            resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                Integer nroCuenta = resultSet.getInt(2);
                String nombre = resultSet.getString(3);
                double saldo = resultSet.getDouble(4);
                cuentaDesdeDB = new Cuenta(id, nroCuenta, nombre, saldo);
            }
                logger.info("Información cuenta: "+cuentaDesdeDB);
            //Update con transaccion
            connection.setAutoCommit(false);
            try {
                PreparedStatement preparedStatement1 = connection.prepareStatement(SQL_UPDATE);
                preparedStatement1.setDouble(1, cuenta.getSaldo()+15);
                preparedStatement1.setInt(2, cuenta.getNroCuenta());
                preparedStatement1.executeUpdate();
                int num =10/0;
                connection.commit();
                cuenta.setSaldo(cuenta.getSaldo()+15);
            }catch (Exception e){
                connection.rollback();
                logger.error(e.getMessage());
            }
            connection.setAutoCommit(true);
                //mostrar datos desde DB
                resultSet = statement.executeQuery(SQL_SELECT);
                while (resultSet.next()){
                    Integer id = resultSet.getInt(1);
                    Integer nroCuenta = resultSet.getInt(2);
                    String nombre = resultSet.getString(3);
                    double saldo = resultSet.getDouble(4);
                    cuentaDesdeDB = new Cuenta(id, nroCuenta, nombre, saldo);
            }
                logger.info("Información cuenta: "+cuentaDesdeDB);

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
        }
    }




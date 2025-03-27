import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class);
    public static String SQL_CREATE = "Drop table if exists Figuras;" +
            "Create table Figuras (id int auto_increment primary key," +
            "fomra varchar(50) not null, color varchar(50) not null)";

    public static String SQL_INSERT = "insert into Figuras values (default, 'Circulo', 'rojo')," +
            "(default, 'Circulo', 'azul'), (default, 'Cuadro', 'rojo'), (default, 'Cuadro', 'azul')," +
            "(default, 'Cuadro', 'amarillo')";
    public static String SQL_SELECT = "select * from Figuras";
    public static String SQL_SELECT_COLOR = "select * from Figuras where color = 'rojo'";

    //public static String SQL_DELETE = "delete from Figuras where";
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);
            statement.execute(SQL_INSERT);
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);

            while (resultSet.next()){
                logger.info("Figura: "+resultSet.getInt(1)+" - "+resultSet.getString(2)+" - "+resultSet.getString(3));
            }
            ResultSet resultSet1 = statement.executeQuery(SQL_SELECT_COLOR);
            logger.info("------------------------------------------------------------");
            while (resultSet1.next()){
                if(resultSet1.getString(3).equalsIgnoreCase("rojo")){
                    logger.info("Figura: "+resultSet1.getInt(1)+" - "+resultSet1.getString(2)+" - "+resultSet1.getString(3));
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Java_exercise", "", "");
    }
}

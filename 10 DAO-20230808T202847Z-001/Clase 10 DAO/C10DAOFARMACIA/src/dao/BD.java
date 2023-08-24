package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//creamos la tabla y la conexion
public class BD {
    //que necesito? ID, NOMBRE, LABORATORIO, CANTIDAD, PRECIO, CODIGO
    private static final Logger logger=Logger.getLogger(BD.class);
    private static  final String SQL_DROP_CREATE="DROP TABLE IF EXISTS MEDICAMENTOS; " +
            "CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, LABORATORIO " +
            "VARCHAR(100) NOT NULL, CANTIDAD INT NOT NULL, PRECIO NUMERIC(10,2) NOT NULL, CODIGO INT NOT NULL)";
    public static void CrearTablas(){
        logger.info("inicio de operaciones de creado de tablas");
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/farmacia","admin", "admin");
    }
}

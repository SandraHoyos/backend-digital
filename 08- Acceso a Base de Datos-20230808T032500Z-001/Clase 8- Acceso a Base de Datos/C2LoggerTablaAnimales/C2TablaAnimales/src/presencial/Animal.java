package presencial;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {
    private static final Logger logger= Logger.getLogger(Animal.class);
    public static void main(String[] args) {
        //ahora me tengo que conectar
        //tengo preparar la tabla
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ANIMALES; " +
                    "CREATE TABLE ANIMALES (ID INT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(40) NOT NULL, TIPO VARCHAR(30) NOT NULL)");
            //INSERTAR 5 ANIMALES
            statement.execute("INSERT INTO ANIMALES VALUES(1,'FIRULAI','PERRO'),(2,'COCO','GATO'),(3,'PICHICHO','PERRO'),(4,'PLUTO','MONO'),(5,'PERCEFONI','ELEFANTE')");
            //MOSTRA LA TABLA(sql le tiene que hablar a java)
            ResultSet rs= statement.executeQuery("SELECT * FROM ANIMALES");
            while(rs.next()){
                System.out.println("Nombre: "+rs.getString(2)+" .-Tipo: "+rs.getString(3));
            }
            //ahora debiamos eliminar un registro
            System.out.println("*********************************************************");

            statement.execute("DELETE FROM ANIMALES WHERE ID=3");
            //MOSTREMOS LA TABLA DE NUEVO
            rs= statement.executeQuery("SELECT * FROM ANIMALES");
            logger.warn("Se elimino el ID: 3");
            while(rs.next()){
                //muestre por pantalla
                System.out.println("ID: "+" "+rs.getInt(1)+" .-Nombre: "+rs.getString(2)+" .-Tipo: "+rs.getString(3));
            }


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }
    public static Connection getConnection() throws Exception{
        //ahora debo cargar el driver
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/tablaAnimales","sa","sa");

    }
}

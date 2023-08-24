package presencial;

import java.sql.*;

//lo primero que debemos hacer es incluir en mi proyecto las librerias pertienentes
public class Cliente {
    //para trabajar las consultas parametrizadas, vamos a dejar como constantes los SQL
    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS CUENTAS; " +
            "CREATE TABLE CUENTAS (ID INT PRIMARY KEY, NOMBRE VARCHAR(40) NOT NULL, " +
            "NUMERO_CUENTA INT NOT NULL, SALDO NUMERIC(10,2) NOT NULL)";
    //EJEMPLO DE NUMERICO
    // 12345689,10 TENGO 10 EN TOTAL, 8 ENTEROS, 2 DECIMALES
    private static final String SQL_INSERT="INSERT INTO CUENTAS VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE CUENTAS SET SALDO=? WHERE ID=?";
    private static final String SQL_SELECT ="SELECT * FROM CUENTAS";

    public static void main(String[] args) {
        Connection connection= null;
        try{
            //necesito traerme la conexion
            connection= getConnection();
            //necesito crear la tabla
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            //ahora necesito insertar
            PreparedStatement ps_insert= connection.prepareStatement(SQL_INSERT);
            //ahora necesito setear los valores ????
            //el primer valor es el orden del signo de interrogación(ubicacion) y el segundo es el valor nonimal
            ps_insert.setInt(1,1);
            ps_insert.setString(2,"Ivan Gomez");
            ps_insert.setInt(3,11111111);
            ps_insert.setDouble(4,250);
            //mandamos a la bdd
            ps_insert.execute();
            //hacemos un update
            PreparedStatement ps_update= connection.prepareStatement(SQL_UPDATE);
            //seteamos valores de los ????
            ps_update.setDouble(1,250+10);
            //ahora viene el where id=?
            ps_update.setInt(2,1);
            //mandamos a la bdd
            ps_update.execute();//<-- aca vuelve el rollback
            connection.setAutoCommit(false);
            //hacemos un update
            PreparedStatement ps_updateTx= connection.prepareStatement(SQL_UPDATE);
            //seteamos valores de los ????
            ps_updateTx.setDouble(1,260+15);
            //ahora viene el where id=?
            ps_updateTx.setInt(2,1);
            //mandamos a la bdd
            ps_updateTx.execute();
            //como generamos una excepcion
            //int x=5/0;
            connection.commit();
            connection.setAutoCommit(true); //siempre es buena practica restituir el valor del set auto commit


        }catch (Exception e){
            try{
                connection.rollback();
            }catch (SQLException roll){
                roll.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        try{
            connection= getConnection();
            //mostremos la tabla
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(SQL_SELECT);
            while(rs.next()){
                System.out.println(".-ID: "+rs.getInt(1)+" .-Nombre: "+rs.getString(2)+".- Num cuenta: "+rs.getInt(3)+".- Saldo: "+rs.getDouble(4));
            }

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
        //este metodo devuelve la bdd
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c20723cuentas","sa", "sa");
    }
}

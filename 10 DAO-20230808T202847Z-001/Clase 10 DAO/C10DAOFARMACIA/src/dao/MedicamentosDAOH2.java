package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//clase que implementa la interfaz para definir el metodo
public class MedicamentosDAOH2 implements iDao<Medicamento>{
    //metodo estatico que usamos para instanciar el logger de APACHE
    private static final Logger logger= Logger.getLogger(MedicamentosDAOH2.class);
    //que necesito? ID, NOMBRE, LABORATORIO, CANTIDAD, PRECIO, CODIGO
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID="SELECT * FROM MEDICAMENTOS WHERE ID=?";
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        logger.info("inicio de las operaciones de guardado");
        //cargar conexion, ejecturar y guardar ese prepared Statement
        Connection connection= null;
        try{
            //me tengo que conectar a la bd
            connection= BD.getConnection();
            PreparedStatement ps_insert= connection.prepareStatement(SQL_INSERT);
            //seteamos los valores
            //ID, NOMBRE, LABORATORIO, CANTIDAD, PRECIO, CODIGO
            ps_insert.setInt(1,medicamento.getId());
            ps_insert.setString(2, medicamento.getNombre());
            ps_insert.setString(3, medicamento.getLaboratorio());
            ps_insert.setInt(4,medicamento.getCantidad());
            ps_insert.setDouble(5,medicamento.getPrecio());
            ps_insert.setInt(6,medicamento.getCodigo());
            ps_insert.execute();
            //termine la carga a la bdd
            logger.info("datos enviados a la BDD");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Medicamento medicamento) {
        logger.info("iniciando la busqueda por ID");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            //preparo el statement
            PreparedStatement psBuscar= connection.prepareStatement(SQL_SELECT_BY_ID);
            logger.info("seteo valores");
            psBuscar.setInt(1,medicamento.getId());
            psBuscar.execute();
            ResultSet rs= psBuscar.executeQuery();
            while (rs.next()){
                System.out.println("id: "+rs.getInt(1)+".- Nombre Medicamento: "+rs.getString(2));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return medicamento;
    }
}

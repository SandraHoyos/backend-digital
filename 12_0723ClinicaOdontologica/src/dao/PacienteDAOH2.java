package dao;

import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente> {
    private static final Logger logger= Logger.getLogger(PacienteDAOH2.class);

    private static final String SQL_INSERT="INSERT INTO PACIENTES VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID =?";
    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("inicio de operacion de guardado");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
            /*Integer id;
     String nombre;
     String apellido;
     String cedula;
     LocalDate fechaIngreso;
     Domicilio domicilio;*/
         psInsert.setString(1, paciente.getNombre());
         psInsert.setString(2, paciente.getApellido());
         psInsert.setString(3, paciente.getCedula());
         psInsert.setDate(4, paciente.getFechaIngreso()));
         psInsert.setInt(5,paciente.getDomicilio().getId());
         ResultSet rs= psInsert.getGeneratedKeys();
         while (rs.next()){
             paciente.setId(rs.getInt(1));
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

    @Override
    public Paciente buscar(Integer id) {
        logger.info("inicio de operacion de guardado");
        Connection connection= null;
        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            connection= BD.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            while(rs.next()){
                domicilio=domicilioDAOH2.buscar(rs.getInt(6));//<<--- FK
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio);

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

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("inicio de operacion de guardado");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement();


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

    @Override
    public void eliminar(Integer id) {
        logger.info("inicio de operacion de guardado");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement();


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

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("inicio de operacion de guardado");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement();


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
}

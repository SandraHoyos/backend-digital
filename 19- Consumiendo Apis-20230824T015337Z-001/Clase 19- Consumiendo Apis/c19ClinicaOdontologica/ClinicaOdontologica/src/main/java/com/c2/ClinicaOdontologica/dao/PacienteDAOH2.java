package com.c2.ClinicaOdontologica.dao;

import com.c2.ClinicaOdontologica.model.Domicilio;
import com.c2.ClinicaOdontologica.model.Paciente;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDAOH2 implements iDao<Paciente> {
    private static final Logger logger= Logger.getLogger(PacienteDAOH2.class);

    private static final String SQL_INSERT="INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID =?";
    private static final String SQL_UPDATE="UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, CEDULA=?, FECHA_INGRESO=?, DOMICILIO_ID=?, EMAIL=? WHERE ID=? ";
    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    private static final String SQL_DELETE="DELETE FROM PACIENTES WHERE ID=?";
    private static  final String SQL_SELECT_BY_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=?";
    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("inicio de operacion de guardado : "+paciente.getNombre());
        Connection connection= null;
        try{
            connection= BD.getConnection();
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            logger.info("domicilio a guardar : "+paciente.getDomicilio().getId());
            Domicilio nuevoDomicilio= daoAux.guardar(paciente.getDomicilio());
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
         psInsert.setString(1, paciente.getNombre());
         psInsert.setString(2, paciente.getApellido());
         psInsert.setString(3, paciente.getCedula());
         psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
         psInsert.setInt(5,nuevoDomicilio.getId());
         psInsert.setString(6, paciente.getEmail());
         psInsert.execute();
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
        return paciente;
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
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));

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

return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("inicio de operacion de actualizar el paciente con ID: "
        +paciente.getId());
        Connection connection= null;
        Domicilio domicilio= null;
        try{
            connection= BD.getConnection();
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
           domicilio = daoAux.buscar(paciente.getDomicilio().getId());
            daoAux.actualizar(domicilio);
            PreparedStatement ps_update= connection.prepareStatement(SQL_UPDATE);
            //parametrizadas
            ps_update.setString(1, paciente.getNombre());
            ps_update.setString(2, paciente.getApellido());
            ps_update.setString(3,paciente.getCedula());
            ps_update.setDate(4,Date.valueOf(paciente.getFechaIngreso()));
            //necesito el domicilio
            ps_update.setInt(5,domicilio.getId());
            ps_update.setString(6, paciente.getEmail());
            ps_update.setInt(7,paciente.getId());
            ps_update.execute();


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
            PreparedStatement psInsert= connection.prepareStatement(SQL_DELETE);


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
        //necesito inicializar una lista
        List<Paciente> pacientes= new ArrayList<>();
        Paciente paciente= null;
        Domicilio domicilio=null;

        try{
            connection= BD.getConnection();
            PreparedStatement psSelectAll= connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSelectAll.executeQuery();
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            while (rs.next()){
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
                pacientes.add(paciente);
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
        return pacientes;

    }

    @Override
    public Paciente buscarPorString(String valor) {
        logger.info("inicio de operacion de buscado por email:"+valor);
        Connection connection= null;
        Paciente paciente= null;
        Domicilio domicilio=null;
        DomicilioDAOH2 daoAux= new DomicilioDAOH2();
        try{
            connection= BD.getConnection();
            PreparedStatement psSelectEmail= connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            //seteamos las parametrizadas
            psSelectEmail.setString(1,valor);
            ResultSet rs= psSelectEmail.executeQuery();
            while (rs.next()){
                domicilio= daoAux.buscar(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
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
        return paciente;
    }

}

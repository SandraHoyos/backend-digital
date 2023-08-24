package com.c2.ClinicaOdontologica.repository;

import com.c2.ClinicaOdontologica.entity.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?)";
    private static final String SELECT_BY_ID="SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_DELETE="DELETE * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_UPDATE="UPDATE ODONTOLOGOS SET NOMBRE=?, APELLIDO=?, MATRICULA=? WHERE ID=?";
    private static final Logger logger=Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("inicio de operacion de guardado del odontologo : "+odontologo.getMatricula());
        Connection connection= null;
          try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getNombre());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.setString(3,odontologo.getMatricula());
            psInsert.execute();

            //necesito capturas las id
              ResultSet rs= psInsert.getGeneratedKeys();
              while (rs.next()){
                  odontologo.setId(rs.getInt(1));
                  logger.info("odontologo con id");
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
          return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        logger.info("inicio de operacion de guardado");
        Connection connection= null;
        Odontologo odontologo= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SELECT_BY_ID);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            while (rs.next()){
                //construime el odontologo
                odontologo= new Odontologo(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));

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
        return odontologo;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        logger.info("inicio de operacion de guardado");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,odontologo.getNombre());
            psUpdate.setString(2,odontologo.getApellido());
            psUpdate.setString(3,odontologo.getMatricula());
            psUpdate.setInt(4,odontologo.getId());
            psUpdate.execute();

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
            PreparedStatement psDelete= connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1,id);
            psDelete.execute();


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
    public List<Odontologo> buscarTodos() {
        logger.info("inicio de operacion de listado de Odontologos");
        Connection connection= null;
        List<Odontologo> odontologos= new ArrayList<>();
        Odontologo odontologo= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psselectAll= connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psselectAll.executeQuery();
            while (rs.next()){
                //construir el odontologo
                odontologo= new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                odontologos.add(odontologo);
                logger.info("inicio de operacion de objeto construido y agregado a la lista");
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
        logger.info("inicio de operacion de retorno de la lista");
        return odontologos;

    }

    @Override
    public Odontologo buscarPorString(String valor) {
        return null;
    }
}

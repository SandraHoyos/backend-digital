package com.c2.ClinicaOdontologica.service;

import com.c2.ClinicaOdontologica.dao.OdontologoDAOH2;
import com.c2.ClinicaOdontologica.dao.iDao;
import com.c2.ClinicaOdontologica.model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    //necesito un idao
    private iDao<Odontologo> odontologoiDao= new OdontologoDAOH2();
    //definir todos y cada uno de los metodos para trabajar con el modelo de negocio
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }
    public Odontologo buscarPorID(Integer id){
        return odontologoiDao.buscar(id);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoiDao.actualizar(odontologo);
    }
    public void eliminarOdontologo(Integer id){
        odontologoiDao.eliminar(id);
    }
    public List<Odontologo> listarOdontologos(){
        return odontologoiDao.buscarTodos();
    }

}

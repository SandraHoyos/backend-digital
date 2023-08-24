package service;

import dao.OdontologoDAOH2;
import dao.iDao;
import model.Odontologo;

import java.util.List;

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

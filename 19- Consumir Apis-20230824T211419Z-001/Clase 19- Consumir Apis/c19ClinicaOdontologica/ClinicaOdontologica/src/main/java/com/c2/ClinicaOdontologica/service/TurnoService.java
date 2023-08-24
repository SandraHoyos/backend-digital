package com.c2.ClinicaOdontologica.service;

import com.c2.ClinicaOdontologica.dao.TurnoDAOLista;
import com.c2.ClinicaOdontologica.dao.iDao;
import com.c2.ClinicaOdontologica.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    //relacion de asociacion
    private iDao<Turno> turnoiDao= new TurnoDAOLista();
    //hacer manuales los metodos
    public List<Turno> obtenerTodosLosTurnos(){
         return turnoiDao.buscarTodos();
    }
    public Turno buscarTurnoPorId(Integer id){
        return turnoiDao.buscar(id);
    }
    public void eliminarTurno(Integer id){
        turnoiDao.eliminar(id);
    }
    public void actualizarTurno(Turno turno){
        turnoiDao.actualizar(turno);
    }
    public Turno guardarTurno(Turno turno){
        return turnoiDao.guardar(turno);
    }
}

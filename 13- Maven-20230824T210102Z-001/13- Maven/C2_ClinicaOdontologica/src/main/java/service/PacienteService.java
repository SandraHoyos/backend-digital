package service;

import dao.PacienteDAOH2;
import dao.iDao;
import model.Paciente;

import java.util.List;

public class PacienteService {
    private iDao<Paciente> pacienteiDao= new PacienteDAOH2();
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPacientePorID(Integer id){
        return pacienteiDao.buscar(id);
    }
    public void actualizarPaciente(Paciente paciente){
         pacienteiDao.actualizar(paciente);
    }
    public void eliminarPaciente(Integer id){
        pacienteiDao.eliminar(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteiDao.buscarTodos();
    }
}

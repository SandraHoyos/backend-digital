package com.c2.ClinicaOdontologica.service;

import com.c2.ClinicaOdontologica.dao.PacienteDAOH2;
import com.c2.ClinicaOdontologica.dao.iDao;
import com.c2.ClinicaOdontologica.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
     public Paciente buscarPorEmail(String email){
        return pacienteiDao.buscarPorString(email);
     }
}

package com.c3.ClinicaOdontologica.service;

import com.c3.ClinicaOdontologica.dao.PacienteDAOH2;
import com.c3.ClinicaOdontologica.dao.iDao;
import com.c3.ClinicaOdontologica.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private iDao<Paciente> pacienteiDao= new PacienteDAOH2();
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorID(Integer id){
        return pacienteiDao.buscar(id);
    }
    public void eliminarPaciente(Integer id){
        pacienteiDao.eliminar(id);
    }
    public void actualizarPaciente(Paciente paciente){
        pacienteiDao.actualizar(paciente);
    }
    public List<Paciente> obtenerPacientes(){
        return pacienteiDao.buscarTodos();
    }
    public Paciente buscarPorEmail(String correo){
        return pacienteiDao.buscarPorString(correo);
    }
}

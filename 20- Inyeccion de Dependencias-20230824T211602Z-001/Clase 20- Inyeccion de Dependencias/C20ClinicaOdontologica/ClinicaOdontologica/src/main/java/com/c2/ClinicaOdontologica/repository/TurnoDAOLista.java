package com.c2.ClinicaOdontologica.repository;

import com.c2.ClinicaOdontologica.entity.Turno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoDAOLista implements iDao<Turno>{
    private List<Turno> turnos = new ArrayList<>();
    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        //como buscamos un turno en una lista?
        for (Turno turno:turnos) { //<--- for each
            if (turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Turno turno) {
        eliminar(turno.getId());
        guardar(turno);

    }

    @Override
    public void eliminar(Integer id) {
        Turno turnoBuscado= buscar(id);
        turnos.remove(turnoBuscado);

    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno buscarPorString(String valor) {
        return null;
    }
}

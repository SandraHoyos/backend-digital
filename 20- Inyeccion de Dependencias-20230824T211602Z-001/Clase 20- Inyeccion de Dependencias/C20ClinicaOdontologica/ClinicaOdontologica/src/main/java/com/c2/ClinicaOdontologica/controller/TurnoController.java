package com.c2.ClinicaOdontologica.controller;

import com.c2.ClinicaOdontologica.entity.Turno;
import com.c2.ClinicaOdontologica.service.OdontologoService;
import com.c2.ClinicaOdontologica.service.PacienteService;
import com.c2.ClinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    //con quien lo asociamos
    @Autowired
    private TurnoService turnoService= new TurnoService();
    @GetMapping
    public ResponseEntity<List<Turno>> listarTodosLosTurnos(){

        return ResponseEntity.ok(turnoService.obtenerTodosLosTurnos());
    }
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        //segun el enunciado habia que validar si existia un odontologo o paciente
        OdontologoService odontologoService= new OdontologoService();
        PacienteService pacienteService= new PacienteService();
        if (odontologoService.buscarPorID(turno.getOdontologo().getId())!=null&&pacienteService.buscarPacientePorID(turno.getPaciente().getId())!=null){
            //quiere decir que ambos exiten
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else {
            //si esa condicion no existe, osea no hay odo o pac?
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody Turno turno){
        Turno turnoBuscado= turnoService.buscarTurnoPorId(turno.getId());
        if(turnoBuscado!=null){
            turnoService.actualizarTurno(turnoBuscado);
            return ResponseEntity.ok("Turno actualizado con exito");
        }else {
            return ResponseEntity.badRequest().body("Error al actualizar Turno");

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorID(@PathVariable Integer id){
        Turno turnoBuscado= turnoService.buscarTurnoPorId(id);
        if(turnoBuscado!=null){
            return ResponseEntity.ok((turnoBuscado));

        }else {
            return ResponseEntity.badRequest().build();

        }
    }


}

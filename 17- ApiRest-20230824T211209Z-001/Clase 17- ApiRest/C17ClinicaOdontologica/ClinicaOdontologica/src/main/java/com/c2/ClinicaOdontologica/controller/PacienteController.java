package com.c2.ClinicaOdontologica.controller;

import com.c2.ClinicaOdontologica.model.Paciente;
import com.c2.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController //tecnologia de vista
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService= new PacienteService();


   //metodos http, que usamos?
    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }
    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        //que harian como primera medida.
        Paciente pacienteBuscado= pacienteService.buscarPacientePorID(paciente.getId());
        //ahora que sabemos que esta o no, que deberiamos hacer?
        if(pacienteBuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "Paciente Actualizado con exito -"+paciente.getNombre();
        }else{
            return "No se encontro para actualizar el paciente: "+paciente.getNombre()+ " Con ID:"+paciente.getId();
        }
    }
    @GetMapping
    public String buscarPacientePorEmail(Model model, @RequestParam("email") String email){
        Paciente paciente= pacienteService.buscarPorEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";


    }
}

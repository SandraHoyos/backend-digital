package com.c3.Entrenador.Controller;

import com.c3.Entrenador.Model.Entrenador;
import com.c3.Entrenador.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController// permite que yo trabaje sin tecnologia de vista
@RequestMapping("entrenador")
public class EntrenadorController {
    //establecer la conexion con el dao,
    @Autowired
    private EntrenadorService entrenadorService= new EntrenadorService();
   @GetMapping
    public List<Entrenador> obtenerLista(){
        return entrenadorService.listaEntrenador();
    }
}

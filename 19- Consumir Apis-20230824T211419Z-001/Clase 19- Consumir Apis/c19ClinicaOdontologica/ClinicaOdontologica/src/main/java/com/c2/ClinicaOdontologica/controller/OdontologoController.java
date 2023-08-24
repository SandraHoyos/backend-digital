package com.c2.ClinicaOdontologica.controller;

import com.c2.ClinicaOdontologica.model.Odontologo;
import com.c2.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    //asociamos
    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;

   }
   @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodosLosOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
   }
   @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
   }

}

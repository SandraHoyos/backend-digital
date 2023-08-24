package com.c2.ClinicaOdontologica.controller;

import com.c2.ClinicaOdontologica.entity.Odontologo;
import com.c2.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
   @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorID(@PathVariable Integer id){
       Odontologo odontologo= odontologoService.buscarPorID(id);
       if(odontologo!=null){
           return ResponseEntity.ok(odontologo);
       }else{
           return ResponseEntity.notFound().build();
       }
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id){
       Odontologo odontologo= odontologoService.buscarPorID(id);
       if (odontologo!=null){
           odontologoService.eliminarOdontologo(id);
           return ResponseEntity.ok("Se elimino correctamente");
       }else{
           return ResponseEntity.badRequest().body("Error, no se encontró");

       }
   }


}

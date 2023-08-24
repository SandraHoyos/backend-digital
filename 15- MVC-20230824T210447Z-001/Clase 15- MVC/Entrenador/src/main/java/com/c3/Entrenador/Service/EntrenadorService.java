package com.c3.Entrenador.Service;

import com.c3.Entrenador.Model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorService implements iEntrenadorService{
    @Override
    public List<Entrenador> listaEntrenador() {
        //aca deberia venir el dao
        return Arrays.asList(new Entrenador("Jorgito Coach"),new Entrenador("Miguel DT"));
    }
}

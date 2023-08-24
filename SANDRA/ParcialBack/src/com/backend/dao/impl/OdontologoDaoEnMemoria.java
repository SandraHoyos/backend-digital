package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);

    private List<Odontologo> odontologosRepository;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologosRepository) {
        this.odontologosRepository = odontologosRepository;
    }

    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        odontologosRepository.add(odontologo);
        LOGGER.info("Odontólogo registrado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        LOGGER.info("Listado de todos los odontólogos: " + odontologosRepository);
        return odontologosRepository;
    }
}

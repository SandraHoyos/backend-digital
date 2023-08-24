package com.c2.ClinicaOdontologica.dao;

import java.util.List;

public interface iDao<T> {
      T guardar(T t);
      
      T buscar(Integer id);
      void actualizar(T t);
      void eliminar(Integer id);
      List<T> buscarTodos();
      T buscarPorString(String valor);
}

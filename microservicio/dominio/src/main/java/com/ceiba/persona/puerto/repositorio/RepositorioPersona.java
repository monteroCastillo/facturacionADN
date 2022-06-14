package com.ceiba.persona.puerto.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;

import java.util.List;
import java.util.Optional;

public interface RepositorioPersona {

    Persona obtener(Long idPersona);
    Long guardar(Persona persona);
//
//    void eliminar(Long idPersona);
//
//    List<Persona> buscarTodos();

    Persona buscarPersonaPorID(Long idPersona);

    boolean existe(Long id);
}

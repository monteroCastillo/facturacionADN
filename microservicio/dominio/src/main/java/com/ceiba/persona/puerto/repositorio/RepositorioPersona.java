package com.ceiba.persona.puerto.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;

import java.util.List;
import java.util.Optional;

public interface RepositorioPersona {

    void guardar(Persona persona);

    void eliminar(Long idPersona);

    List<Persona> buscarTodos();

    Optional<Persona> buscarPersonaPorID(Long idPersona);
}

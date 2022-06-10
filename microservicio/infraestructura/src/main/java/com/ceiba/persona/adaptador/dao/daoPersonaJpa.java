package com.ceiba.persona.adaptador.dao;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.adaptador.repositorio.RepositorioPersonaJpa;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class daoPersonaJpa implements RepositorioPersona {

    @Autowired
    private RepositorioPersonaJpa repoPersona;



    public void guardar(Persona persona) {
        repoPersona.save(persona);
    }

//    @Override
//    public void eliminar(Long idPersona) {
//        repoPersona.delete(idPersona);
//    }

    public void eliminar(Long idPersona) {
        repoPersona.deleteById(idPersona);
    }

    public List<Persona> buscarTodos() {
        return repoPersona.findAll();
    }

    @Override
    public Optional<Persona> buscarPersonaPorID(Long idPersona) {
        return Optional.empty();
    }
}

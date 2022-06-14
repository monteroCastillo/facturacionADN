package com.ceiba.persona.adaptador.dao;

import com.ceiba.persona.adaptador.repositorio.RepositorioPersonaMysql;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class daoPersona implements RepositorioPersona {


    @Autowired
    private RepositorioPersonaMysql repoPersona;


    @Override
    public Persona obtener(Long idPersona) {
        return null;
    }

    @Override
    public Long guardar(Persona persona) {
       return  repoPersona.guardar(persona);
    }

    @Override
    public Persona buscarPersonaPorID(Long idPersona) {
        return null;
    }

    @Override
    public boolean existe(Long id) {
        return false;
    }


//
//    public void eliminar(Long idPersona) {
//        repoPersona.deleteById(idPersona);
//    }
//
//    public List<Persona> buscarTodos() {
//        return repoPersona.findAll();
//    }


}

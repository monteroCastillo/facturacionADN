package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.utils.MensajesDeExcepcion;

public class ServicioCrearPersona {

  private  final RepositorioPersona repositorioPersona;


    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {

        this.repositorioPersona = repositorioPersona;
    }

    public Long ejecutar(Persona persona){
        validarExistenciaPrevia(persona);
        return this.repositorioPersona.guardar(persona);
    }
    private void validarExistenciaPrevia(Persona persona)  {
        boolean existe = this.repositorioPersona.existe(persona.getIdPersona());
        if(existe){
            throw new ExcepcionValorInvalido(MensajesDeExcepcion.YA_EXISTE_UNA_PERSONA_REGISTRADA_CON_ESTE_ID.getMensaje());
        }

    }
}

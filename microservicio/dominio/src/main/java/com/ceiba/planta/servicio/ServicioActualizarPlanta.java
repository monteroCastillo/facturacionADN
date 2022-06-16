package com.ceiba.planta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.persona.utils.MensajesDeExcepcion;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class ServicioActualizarPlanta {

    private final RepositorioPlanta repositorioPlanta;

    public ServicioActualizarPlanta(RepositorioPlanta repositorioPlanta) {
        this.repositorioPlanta = repositorioPlanta;
    }

    public void ejecutar(Planta planta){
        validarExistenciaPrevia(planta);
        this.repositorioPlanta.actualizar(planta);
    }

    private void validarExistenciaPrevia(Planta planta){
        boolean existe = this.repositorioPlanta.existe(planta.getIdPlanta());
        if(!existe) {
            throw new ExcepcionSinDatos(MensajesDeExcepcion.NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID.getMensaje());
        }
    }

}

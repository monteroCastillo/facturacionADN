package com.ceiba.Empleado.utils;

import lombok.Getter;

@Getter
public enum MensajesDeExcepcion {


    YA_EXISTE_UNA_PERSONA_REGISTRADA_CON_ESTE_ID("Ya existe una persona con este id"),
    NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID("No existe un persona con este id");

    private  String mensaje;

    MensajesDeExcepcion(String mensaje){
        this.mensaje=mensaje;
    }
}

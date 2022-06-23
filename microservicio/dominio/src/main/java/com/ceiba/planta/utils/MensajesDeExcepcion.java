package com.ceiba.planta.utils;

import lombok.Getter;

@Getter
public enum MensajesDeExcepcion {

    ES_FIN_DE_SEMANA("Hoy es fin de semana y no se puede recibir mercancia"),
    CREACION_DE_PLANTA_CORRECTA("La planta fue creada con exito");

    private String mensaje;

    MensajesDeExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }
}

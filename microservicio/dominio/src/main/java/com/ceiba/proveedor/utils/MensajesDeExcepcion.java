package com.ceiba.proveedor.utils;

import lombok.Getter;


@Getter
public enum MensajesDeExcepcion {

    YA_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_ID("Ya existe un afiliado con este id"),
    NO_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_ID("No existe un afiliado con este id");



    private  String mensaje;

    MensajesDeExcepcion(String mensaje){
        this.mensaje=mensaje;
    }
}


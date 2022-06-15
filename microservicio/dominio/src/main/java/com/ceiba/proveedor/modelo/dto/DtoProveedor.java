package com.ceiba.proveedor.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProveedor {

    private final Long id;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String paginaWeb;

}

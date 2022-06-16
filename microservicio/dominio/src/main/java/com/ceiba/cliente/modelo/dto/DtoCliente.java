package com.ceiba.cliente.modelo.dto;

import com.ceiba.cliente.modelo.entidad.TipoCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCliente {

    private final Long id;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String email;
    private final TipoCliente tipoCliente;
}

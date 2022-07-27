package com.ceiba.proveedor.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class SolicitudProveedor {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;
}
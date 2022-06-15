package com.ceiba.proveedor.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProveedor {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;

}

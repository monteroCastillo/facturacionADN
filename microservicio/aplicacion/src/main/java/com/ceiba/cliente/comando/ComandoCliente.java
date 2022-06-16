package com.ceiba.cliente.comando;

import com.ceiba.cliente.modelo.entidad.TipoCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {
    private Long id;
    private  String nombre;
    private  String direccion;
    private  String telefono;
    private  String email;
    private  TipoCliente tipoCliente;

}

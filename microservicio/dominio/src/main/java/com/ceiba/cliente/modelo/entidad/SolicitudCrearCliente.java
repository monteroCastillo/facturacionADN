package com.ceiba.cliente.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SolicitudCrearCliente {
    private  Long id;
    private  String nombre;
    private  String direccion;
    private  String telefono;
    private  String email;
    private  TipoCliente tipoCliente;


}

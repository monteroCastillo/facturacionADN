package com.ceiba.cliente;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.TipoCliente;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private TipoCliente tipoCliente;

    public ComandoClienteTestDataBuilder(){
        this.id = 1L;
        this.nombre = "cliente";
        this.direccion = "Av 6";
        this.telefono = "55555";
        this.email = "cliente@gmail.com";
        this.tipoCliente = TipoCliente.COMUN;

    }

    public Cliente reconstruir(){

        return  Cliente.reconstruir(id, nombre, direccion, telefono, email, tipoCliente);
    }
}

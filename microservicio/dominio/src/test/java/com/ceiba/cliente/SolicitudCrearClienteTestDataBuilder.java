package com.ceiba.cliente;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.SolicitudCrearCliente;
import com.ceiba.cliente.modelo.entidad.TipoCliente;


public class SolicitudCrearClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private  String direccion;
    private  String telefono;
    private  String email;
    private TipoCliente tipoCliente;

    public SolicitudCrearClienteTestDataBuilder conClientePorDefecto(){
        this.id = 1l;
        this.nombre = "Cliente 1";
        this.direccion = "Av 6";
        this.telefono = "55555";
        this.email = "cliente@gmail.com";
        this.tipoCliente = TipoCliente.COMUN;
        return this;
    }

    public Cliente reconstruir() {
        return Cliente.reconstruir(id, nombre, direccion, telefono, email, tipoCliente);
    }

    public SolicitudCrearClienteTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public SolicitudCrearClienteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public SolicitudCrearClienteTestDataBuilder conDireccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    public SolicitudCrearClienteTestDataBuilder conTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }
    public SolicitudCrearClienteTestDataBuilder conEmail(String email){
        this.email = email;
        return this;
    }
    public SolicitudCrearClienteTestDataBuilder conTipoCliente(TipoCliente tipoCliente){
        this.tipoCliente = tipoCliente;
        return this;
    }
    public SolicitudCrearCliente construir(){
        return  new SolicitudCrearCliente(id, nombre, direccion,telefono,email,tipoCliente);
    }
}

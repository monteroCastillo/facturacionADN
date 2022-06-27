package com.ceiba.cliente;

import com.ceiba.cliente.modelo.entidad.TipoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {
    private Long id;
    private String nombre;
    private  String direccion;
    private  String telefono;
    private  String email;
    private  TipoCliente tipoCliente;

    public ClienteTestDataBuilder conClientePorDefecto(){
        this.id = 1l;
        this.nombre = "Cliente 1";
        this.direccion = "Av 6";
        this.telefono = "55555";
        this.tipoCliente = TipoCliente.COMUN;
        return this;
    }

    public Cliente reconstruir() {
        return Cliente.reconstruir(id, nombre, direccion, telefono, email, tipoCliente);
    }

    public ClienteTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ClienteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public ClienteTestDataBuilder conDireccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    public ClienteTestDataBuilder conTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }
    public ClienteTestDataBuilder conEmail(String email){
        this.email = email;
        return this;
    }
    public ClienteTestDataBuilder conTipoCliente(TipoCliente tipoCliente){
        this.tipoCliente = tipoCliente;
        return this;
    }
    public Cliente build(){
        return new Cliente(id, nombre, direccion,telefono,email,tipoCliente);
    }
}

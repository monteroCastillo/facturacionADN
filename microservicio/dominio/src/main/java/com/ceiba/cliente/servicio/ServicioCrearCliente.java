package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.planta.modelo.entidad.Planta;

public class ServicioCrearCliente {

    private final RepositorioCliente repositorioCliente;


    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente){
        return this.repositorioCliente.guardar(cliente);
    }

}

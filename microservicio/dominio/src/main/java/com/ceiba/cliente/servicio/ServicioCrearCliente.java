package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.SolicitudCrearCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioCrearCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(SolicitudCrearCliente solicitudCrearCliente){

        var cliente = Cliente.crear(solicitudCrearCliente);
        return repositorioCliente.guardar(cliente);
    }

}

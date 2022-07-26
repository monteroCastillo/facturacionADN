package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.SolicitudCrearCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    private final RepositorioCliente repositorioCliente;


    public FabricaCliente(RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public SolicitudCrearCliente guardarCliente(ComandoCliente comandoCliente){
        return new SolicitudCrearCliente(comandoCliente.getId(), comandoCliente.getNombre(), comandoCliente.getDireccion(), comandoCliente.getTelefono(), comandoCliente.getEmail(), comandoCliente.getTipoCliente());

    }

}

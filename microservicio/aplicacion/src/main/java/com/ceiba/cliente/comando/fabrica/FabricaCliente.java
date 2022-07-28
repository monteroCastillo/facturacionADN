package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.SolicitudCrearCliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public SolicitudCrearCliente guardarCliente(ComandoCliente comandoCliente){
        return new SolicitudCrearCliente(comandoCliente.getId(), comandoCliente.getNombre(), comandoCliente.getDireccion(), comandoCliente.getTelefono(), comandoCliente.getEmail(), comandoCliente.getTipoCliente());

    }

}

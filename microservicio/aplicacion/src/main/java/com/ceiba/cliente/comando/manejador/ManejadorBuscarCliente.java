package com.ceiba.cliente.comando.manejador;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarCliente {
    private final DaoCliente daoCliente;

    public ManejadorBuscarCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }


    public Cliente ejecutar(Long id){
        return this.daoCliente.obtenerClientePorId(id);
    }
}

package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface DaoCliente {
    Cliente obtenerClientePorId(Long id);
}

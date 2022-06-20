package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;

import java.util.List;

public interface DaoCliente {


    Cliente obtenerClientePorId(Long id);
}

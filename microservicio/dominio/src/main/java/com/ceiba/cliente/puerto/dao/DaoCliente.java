package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;

import java.util.List;

public interface DaoCliente {

    List<DtoCliente> listar();

    Cliente obtenerClientePorId(Long id);
}

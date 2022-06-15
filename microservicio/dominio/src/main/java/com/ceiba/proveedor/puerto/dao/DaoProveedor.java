package com.ceiba.proveedor.puerto.dao;

import com.ceiba.proveedor.modelo.dto.DtoProveedor;

import java.util.List;

public interface DaoProveedor {

    List<DtoProveedor> listar();
    DtoProveedor obtenerProveedorPorId(Long id);
}

package com.ceiba.proveedor.puerto.dao;

import com.ceiba.proveedor.modelo.entidad.Proveedor;

import java.util.List;

public interface DaoProveedor {

    List<Proveedor> listar();
    Proveedor obtenerProveedorPorId(Long id);
}

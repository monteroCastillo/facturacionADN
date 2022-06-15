package com.ceiba.proveedor.puerto.repositorio;

import com.ceiba.proveedor.modelo.entidad.Proveedor;

import java.util.List;

public interface RepositorioProveedor {
    Long guardar(Proveedor proveedor);
    void eliminar(Long id);
    List<Proveedor> buscarTodos();

    void actualizar(Proveedor proveedor);
}

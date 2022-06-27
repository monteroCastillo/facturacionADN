package com.ceiba.proveedor.puerto.repositorio;

import com.ceiba.proveedor.modelo.entidad.Proveedor;

public interface RepositorioProveedor {
    Long guardar(Proveedor proveedor);
    void eliminar(Long id);

    void actualizar(Proveedor proveedor);

    boolean existe(Long id);
}

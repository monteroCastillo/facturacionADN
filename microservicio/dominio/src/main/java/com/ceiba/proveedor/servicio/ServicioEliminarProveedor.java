package com.ceiba.proveedor.servicio;

import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;

public class ServicioEliminarProveedor {

    private final RepositorioProveedor repositorioProveedor;


    public ServicioEliminarProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }

    public void ejecutar(Long id){this.repositorioProveedor.eliminar(id);}
}

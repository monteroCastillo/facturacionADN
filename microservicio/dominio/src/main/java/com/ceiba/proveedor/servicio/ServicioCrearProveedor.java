package com.ceiba.proveedor.servicio;


import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;

public class ServicioCrearProveedor {

    private final RepositorioProveedor repositorioProveedor;

    public ServicioCrearProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }

    public Long ejecutar(Proveedor proveedor){
        return this.repositorioProveedor.guardar(proveedor);
    }
}

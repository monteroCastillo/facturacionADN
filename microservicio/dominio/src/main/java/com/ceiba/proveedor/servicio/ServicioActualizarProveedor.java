package com.ceiba.proveedor.servicio;

import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;

public class ServicioActualizarProveedor {

    private final RepositorioProveedor repositorioProveedor;

    public ServicioActualizarProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }



    public void ejecutar(Proveedor proveedor){
        this.repositorioProveedor.actualizar(proveedor);
    }





}

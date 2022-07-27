package com.ceiba.proveedor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.empleado.utils.MensajesDeExcepcion;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.modelo.entidad.SolicitudProveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;

public class ServicioActualizarProveedor {

    private final RepositorioProveedor repositorioProveedor;

    public ServicioActualizarProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }



    public void ejecutar(SolicitudProveedor solicitudProveedor){
        validarExistenciaPrevia(solicitudProveedor);
        var proveedor = Proveedor.crear(solicitudProveedor);
        this.repositorioProveedor.actualizar(proveedor);
    }

    private void validarExistenciaPrevia(SolicitudProveedor solicitudProveedor){
        boolean existe = this.repositorioProveedor.existe(solicitudProveedor.getId());
        if(!existe) {
            throw new ExcepcionSinDatos(MensajesDeExcepcion.NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID.getMensaje());
        }
    }
}

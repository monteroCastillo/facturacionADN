package com.ceiba.persona.comando.fabrica;

import com.ceiba.factura.comando.ComandoProductoFacturar;
import com.ceiba.persona.comando.ComandoSolicitudCrear;
import com.ceiba.factura.modelo.entidad.ProductoFacturar;
import com.ceiba.persona.modelo.entidad.SolicitudCrearPersona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FabricaSolicitudCrearPersona {

    private final RepositorioPersona repositorioPersona;

    public FabricaSolicitudCrearPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public SolicitudCrearPersona crear(ComandoSolicitudCrear comandoSolicitudCrear) {
        return new SolicitudCrearPersona(repositorioPersona.obtener(comandoSolicitudCrear.getIdPersona()));


    }

//    private List<ProductoFacturar> obtenerProductos(List<ComandoProductoFacturar> comandoProductosFacturar) {
//        return comandoProductosFacturar.stream().map(comandoProducto ->
//                        ProductoFacturar.crear(
//                                comandoProducto.getCantidad(),
//                                repositorioPersona.obtener(comandoProducto.getIdProducto())))
//                .toList();
//    }

}

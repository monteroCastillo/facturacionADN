package com.ceiba.factura.comando.fabrica;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.factura.comando.ComandoProductoFacturar;
import com.ceiba.factura.comando.ComandoSolicitudFacturar;
import com.ceiba.factura.modelo.entidad.ProductoFacturar;
import com.ceiba.factura.modelo.entidad.SolicitudFacturar;
import com.ceiba.planta.puerto.dao.DaoPlanta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FabricaSolicitudFacturar {


    private final RepositorioCliente repositorioCliente;
    private final DaoPlanta daoPlanta;

    public FabricaSolicitudFacturar( RepositorioCliente repositorioCliente, DaoPlanta daoPlanta) {

        this.repositorioCliente = repositorioCliente;
        this.daoPlanta = daoPlanta;
    }

    public SolicitudFacturar crear(ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return new SolicitudFacturar(repositorioCliente.obtener(comandoSolicitudFacturar.getIdCliente()),
               obtenerProductos(comandoSolicitudFacturar.getComandoProductosFacturar())
        );
    }

    private List<ProductoFacturar> obtenerProductos(List<ComandoProductoFacturar> comandoProductosFacturar) {
        return comandoProductosFacturar.stream().map(comandoPlanta ->
                        ProductoFacturar.crear(
                                comandoPlanta.getCantidad(),
                                daoPlanta.obtener(comandoPlanta.getIdPlanta())))
                .toList();
    }
}

package com.ceiba.factura.comando.manejador;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorMostrarFacturas {
    private final RepositorioFactura repositorioFactura;

    public ManejadorMostrarFacturas(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public Factura ejecutar(Long id){
        return this.repositorioFactura.obtener(id);
    }
}

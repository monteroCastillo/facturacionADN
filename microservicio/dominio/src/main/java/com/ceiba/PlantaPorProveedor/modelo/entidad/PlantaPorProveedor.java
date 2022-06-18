package com.ceiba.PlantaPorProveedor.modelo.entidad;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class PlantaPorProveedor {
    private Long id;
    private Proveedor idProveedor;
    private Planta idPlanta;

    public PlantaPorProveedor(Long id, Proveedor idProveedor, Planta idPlanta) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.idPlanta = idPlanta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Planta getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Planta idPlanta) {
        this.idPlanta = idPlanta;
    }
}

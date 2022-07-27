package com.ceiba.plantaporproveedor.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.proveedor.modelo.entidad.Proveedor;


public class PlantaPorProveedor {
    private Long id;
    private Proveedor proveedor;
    private Planta planta;

    private PlantaPorProveedor(Long id, Proveedor proveedor, Planta planta) {
        this.id = id;
        this.proveedor = proveedor;
        this.planta = planta;
    }

    private PlantaPorProveedor(Proveedor proveedor, Planta planta) {
        this.proveedor = proveedor;
        this.planta = planta;
    }

    public static PlantaPorProveedor crear(SolicitudCrearPlantaPorProveedor solicitudCrearPlantaPorProveedor){

        ValidadorArgumento.validarObligatorio(solicitudCrearPlantaPorProveedor.getProveedor(), "El proveedor es necesario");
                ValidadorArgumento.validarObligatorio(solicitudCrearPlantaPorProveedor.getPlanta(), "El id de la planta es necesario");
                        return new PlantaPorProveedor(solicitudCrearPlantaPorProveedor.getProveedor(),solicitudCrearPlantaPorProveedor.getPlanta());
    }
    public static PlantaPorProveedor reconstruir(Long id, Proveedor idProveedor, Planta idPlanta) {
        ValidadorArgumento.validarObligatorio(idProveedor, "Proveedor es requerido");
        ValidadorArgumento.validarObligatorio(idPlanta, "Planta es requerida");
        return new PlantaPorProveedor(id, idProveedor, idPlanta);
    }

    public Long getId() {
        return id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Planta getPlanta() {
        return planta;
    }
}

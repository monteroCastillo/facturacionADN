package com.ceiba.plantaporproveedor.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class PlantaPorProveedor {
    private Long id;
    private Proveedor proveedor;
    private Planta planta;

    public PlantaPorProveedor(Long id, Proveedor proveedor, Planta planta) {
        this.id = id;
        this.proveedor = proveedor;
        this.planta = planta;
    }

    public PlantaPorProveedor(Proveedor proveedor, Planta planta) {
        this.proveedor = proveedor;
        this.planta = planta;
    }

    public static PlantaPorProveedor crear(SolicitudCrearPlantaPorProveedor solicitudCrearPlantaPorProveedor){

        System.out.println("****Mensaje desde la entidad PROVEEDOR ****" + solicitudCrearPlantaPorProveedor.getProveedor());
        System.out.println("****Mensaje desde la entidad PLANTA  ******" + solicitudCrearPlantaPorProveedor.getPlanta());

        ValidadorArgumento.validarObligatorio(solicitudCrearPlantaPorProveedor.getProveedor().getId(), "El id del proveedor es necesario");
                ValidadorArgumento.validarObligatorio(solicitudCrearPlantaPorProveedor.getPlanta().getIdPlanta(), "El id de la planta es necesario");
                        return new PlantaPorProveedor(solicitudCrearPlantaPorProveedor.getProveedor(),solicitudCrearPlantaPorProveedor.getPlanta());
    }


    public static PlantaPorProveedor reconstruir(Long id, Proveedor proveedor, Planta planta) {
        ValidadorArgumento.validarObligatorio(proveedor, "proveedor es requerido");
        ValidadorArgumento.validarObligatorio(planta, "Planta es requerida");
        return new PlantaPorProveedor(id, proveedor, planta);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}

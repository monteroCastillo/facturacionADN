package com.ceiba.plantaporproveedor.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;


public class PlantaPorProveedor {
    private Long id;
    private Long idProveedor;
    private int idPlanta;

    public PlantaPorProveedor(Long id, Long idProveedor, int idPlanta) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.idPlanta = idPlanta;
    }

    public PlantaPorProveedor(Long idProveedor, int idPlanta) {
        this.idProveedor = idProveedor;
        this.idPlanta = idPlanta;
    }

    public static PlantaPorProveedor crear(SolicitudCrearPlantaPorProveedor solicitudCrearPlantaPorProveedor){

        ValidadorArgumento.validarObligatorio(solicitudCrearPlantaPorProveedor.getIdProveedor(), "El id del proveedor es necesario");
                ValidadorArgumento.validarObligatorio(solicitudCrearPlantaPorProveedor.getIdPlanta(), "El id de la planta es necesario");
                        return new PlantaPorProveedor(solicitudCrearPlantaPorProveedor.getIdProveedor(),solicitudCrearPlantaPorProveedor.getIdPlanta());
    }
    public static PlantaPorProveedor reconstruir(Long id, Long idProveedor, int idPlanta) {
        ValidadorArgumento.validarObligatorio(idProveedor, "Proveedor es requerido");
        ValidadorArgumento.validarObligatorio(idPlanta, "Planta es requerida");
        return new PlantaPorProveedor(id, idProveedor, idPlanta);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }
}

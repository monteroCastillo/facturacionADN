package com.ceiba.plantaporproveedor;

import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.plantaporproveedor.modelo.entidad.SolicitudCrearPlantaPorProveedor;
import com.ceiba.proveedor.ProveedorTestDataBuilder;
import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class SolicitudCrearPlantaPorProveedorTestDataBuilder {

    private Long id;
    private Proveedor proveedor;
    private Planta planta;

    public SolicitudCrearPlantaPorProveedorTestDataBuilder conPlantaPorProveedorPorDefecto(){
        this.id= 1L;
        this.proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().reconstruir();
        this.planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();
        return this;
    }

    public SolicitudCrearPlantaPorProveedorTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public SolicitudCrearPlantaPorProveedorTestDataBuilder conProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
        return this;
    }

    public SolicitudCrearPlantaPorProveedorTestDataBuilder conPlanta(Planta planta){
        this.planta = planta;
        return this;
    }



    public SolicitudCrearPlantaPorProveedor construir( ) {
        return  new SolicitudCrearPlantaPorProveedor(id, proveedor, planta);
    }

}

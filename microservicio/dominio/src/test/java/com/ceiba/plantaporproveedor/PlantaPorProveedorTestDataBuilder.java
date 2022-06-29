package com.ceiba.plantaporproveedor;

import com.ceiba.factura.FacturaTestDataBuilder;
import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.proveedor.ProveedorTestDataBuilder;
import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class PlantaPorProveedorTestDataBuilder {
    private Long id;
    private Long idProveedor;
    private int idPlanta;

    public PlantaPorProveedorTestDataBuilder conPlantaPorProveedorPorDefecto(){
        this.id= 1L;
        this.idProveedor = 22l;
        this.idPlanta = 12;
        return this;
    }
    public PlantaPorProveedor reconstruir(){ return PlantaPorProveedor.reconstruir(id, idProveedor,idPlanta);}

    public PlantaPorProveedor crear(){ return PlantaPorProveedor.reconstruir(id, idProveedor,idPlanta);}

    public PlantaPorProveedorTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public PlantaPorProveedorTestDataBuilder conProveedor(Long idProveedor){
        this.idProveedor = idProveedor;
        return this;
    }

    public PlantaPorProveedorTestDataBuilder conPlanta(int idPlanta){
        this.idPlanta = idPlanta;
        return this;
    }

    public PlantaPorProveedor build( ) {
        return new PlantaPorProveedor(id, idProveedor, idPlanta);
    }


}

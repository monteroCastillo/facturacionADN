package com.ceiba.plantaporproveedor;


import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.proveedor.ProveedorTestDataBuilder;
import com.ceiba.proveedor.modelo.entidad.Proveedor;


public class PlantaPorProveedorTestDataBuilder {
    private Long id;
    private Proveedor proveedor;

    private Planta planta;

    public PlantaPorProveedorTestDataBuilder conPlantaPorProveedorPorDefecto(){
        this.id= 1L;
        this.proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().reconstruir();
        this.planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();
        return this;
    }

    public PlantaPorProveedorTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public PlantaPorProveedorTestDataBuilder conProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
        return this;
    }

    public PlantaPorProveedorTestDataBuilder conPlanta(Planta planta){
        this.planta = planta;
        return this;
    }



    public PlantaPorProveedor reconstruir( ) {
        return  PlantaPorProveedor.reconstruir(id, proveedor, planta);
    }


}

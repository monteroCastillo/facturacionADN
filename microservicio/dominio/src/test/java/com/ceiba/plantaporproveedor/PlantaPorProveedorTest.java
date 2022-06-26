package com.ceiba.plantaporproveedor;

import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.proveedor.ProveedorTestDataBuilder;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlantaPorProveedorTest {
    @Test
    void deberiaReconstruirPlantaPorProveedorExitosamente(){
        Proveedor proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().build();
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().build();

        var plantaPorProveedor = new PlantaPorProveedorTestDataBuilder()
                .conProveedor(proveedor)
                .conPlanta(planta)
                .reconstruir();


        Assertions.assertEquals(proveedor, plantaPorProveedor.getProveedor());
        Assertions.assertEquals(planta,plantaPorProveedor.getPlanta() );
    }
}

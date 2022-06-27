package com.ceiba.plantaporproveedor;

import com.ceiba.BasePrueba;
import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
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

    @Test
    void ReconstruirSinProveedorDeberiaLanzarError(){
       Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().build();
        BasePrueba.assertThrows(() -> new PlantaPorProveedorTestDataBuilder()
                .conPlanta(planta)
                .reconstruir(),ExcepcionValorObligatorio.class,
                "proveedor es requerido");

    }

    @Test
    void ReconstruirSinPlantaDeberiaLanzarError(){
        Proveedor proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().build();

        BasePrueba.assertThrows(() -> new PlantaPorProveedorTestDataBuilder()
                        .conProveedor(proveedor)
                        .reconstruir(),ExcepcionValorObligatorio.class,
                "Planta es requerida");

    }



}

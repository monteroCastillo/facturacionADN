package com.ceiba.plantaporproveedor;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.proveedor.ProveedorTestDataBuilder;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlantaPorProveedorTest {
    @Test
    void deberiaReconstruirPlantaPorProveedorExitosamente(){

        Proveedor proveedor = new ProveedorTestDataBuilder()
                .conProveedorPorDefecto()
                .reconstruir();

        Planta  planta = new PlantaTestDataBuilder()
                .conPlantaPorDefecto()
                .reconstruir();

        var plantaPorProveedor = new PlantaPorProveedorTestDataBuilder()
                .conProveedor(proveedor)
                .conPlanta(planta)
                .reconstruir();

        Assertions.assertEquals(1l, plantaPorProveedor.getProveedor().getId());
        Assertions.assertEquals(1l,plantaPorProveedor.getPlanta().getId() );
    }


    @Test
    void deberiaCrearPlantaPorProveedorExitosamente(){
        Proveedor proveedor = new ProveedorTestDataBuilder()
                .conProveedorPorDefecto()
                .reconstruir();

        Planta  planta = new PlantaTestDataBuilder()
                .conPlantaPorDefecto()
                .reconstruir();

        var plantaPorProveedor = new PlantaPorProveedorTestDataBuilder()
                .conProveedor(proveedor)
                .conPlanta(planta)
                .reconstruir();


        Assertions.assertEquals(1l, plantaPorProveedor.getProveedor().getId());
        Assertions.assertEquals(1l,plantaPorProveedor.getPlanta().getId() );
    }

    @Test
    void crearSinProveedorDeberiaLanzarError(){
        Planta  planta = new PlantaTestDataBuilder()
                .conPlantaPorDefecto()
                .reconstruir();
        BasePrueba.assertThrows(() -> new PlantaPorProveedorTestDataBuilder()

                        .conPlanta(planta)
                        .reconstruir(),ExcepcionValorObligatorio.class,
                "Proveedor es requerido");

    }

    @Test
    void crearSinPlantaDeberiaLanzarError(){
        Proveedor proveedor = new ProveedorTestDataBuilder()
                .conProveedorPorDefecto()
                .reconstruir();

        BasePrueba.assertThrows(() -> new PlantaPorProveedorTestDataBuilder()

                        .conProveedor(proveedor)
                        .reconstruir(),ExcepcionValorObligatorio.class,
                "Planta es requerida");

    }


}

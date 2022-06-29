package com.ceiba.plantaporproveedor;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlantaPorProveedorTest {
    @Test
    void deberiaReconstruirPlantaPorProveedorExitosamente(){

        var plantaPorProveedor = new PlantaPorProveedorTestDataBuilder()
                .conId(2l)
                .conProveedor(22l)
                .conPlanta(12)
                .reconstruir();
        Assertions.assertEquals(2l, plantaPorProveedor.getId());
        Assertions.assertEquals(22l, plantaPorProveedor.getIdProveedor());
        Assertions.assertEquals(12,plantaPorProveedor.getIdPlanta() );
    }

    @Test
    void ReconstruirSinProveedorDeberiaLanzarError(){

        BasePrueba.assertThrows(() -> new PlantaPorProveedorTestDataBuilder()
                .conPlanta(12)
                .reconstruir(),ExcepcionValorObligatorio.class,
                "Proveedor es requerido");
    }
    @Test
    void deberiaCrearPlantaPorProveedorExitosamente(){

        var plantaPorProveedor = new PlantaPorProveedorTestDataBuilder()

                .conProveedor(22l)
                .conPlanta(12)
                .crear();

        Assertions.assertEquals(22l, plantaPorProveedor.getIdProveedor());
        Assertions.assertEquals(12,plantaPorProveedor.getIdPlanta() );
    }

    @Test
    void crearSinProveedorDeberiaLanzarError(){
        BasePrueba.assertThrows(() -> new PlantaPorProveedorTestDataBuilder()

                        .conPlanta(12)
                        .crear(),ExcepcionValorObligatorio.class,
                "El id del proveedor es necesario");

    }



}

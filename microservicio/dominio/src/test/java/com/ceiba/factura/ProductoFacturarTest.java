package com.ceiba.factura;

import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductoFacturarTest {

    @Test
    void construirProductoFacturaTestExitosamente(){

        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();

        var productoFacturar = new ProductoFacturarTestDataBuilder()
                .conId(1l)
                .conPlanta(planta)
                .conCantidad(5).reconstruir();
        Assertions.assertEquals(1l,productoFacturar.getId());
        Assertions.assertEquals("rosa",productoFacturar.getPlanta().getNombre());
        Assertions.assertEquals(1l,productoFacturar.getId());
    }

    @Test
    void calcularSubTotalExitosamente(){
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();

        var productoFacturar = new ProductoFacturarTestDataBuilder()
                .conId(1l)
                .conPlanta(planta)
                .conCantidad(5).reconstruir();
        BigDecimal subTotal = productoFacturar.calcularSubTotal();
        Assertions.assertEquals(productoFacturar.calcularTotal(),subTotal);
    }



}

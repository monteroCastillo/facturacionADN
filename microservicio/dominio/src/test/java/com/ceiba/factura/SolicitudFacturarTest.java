package com.ceiba.factura;

import com.ceiba.cliente.ClienteTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.factura.modelo.entidad.ProductoFacturar;
import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitudFacturarTest {

    @Test
    void solicitudFacturarTestExitosamente(){
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();
        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruir();

        List<ProductoFacturar> productosFacturar = new ArrayList<>();
        productosFacturar.add(0,ProductoFacturar.crear(5,planta));

        var solicitudFacturar = new SolicitudFacturarTestDataBuilder()
                .conFechaIngreso(LocalDate.of(2022,06,22))
                .conProductoFacturar(new ProductoFacturar(1l,5,planta))
                .conCliente(cliente)
                .build();
        Assertions.assertEquals(LocalDate.of(2022,06,22), solicitudFacturar.getFechaIngreso());
    }

    @Test
    void solicitudFacturarCrearTestExitosamente(){
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();
        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruir();

        List<ProductoFacturar> productosFacturar = new ArrayList<>();
        productosFacturar.add(0,ProductoFacturar.crear(5,planta));

        var solicitudFacturar = new SolicitudFacturarTestDataBuilder()
                .conFechaIngreso(LocalDate.of(2022,06,22))
                .conProductoFacturar(new ProductoFacturar(1l,5,planta))
                .conCliente(cliente)
                .crear();
        Assertions.assertEquals(LocalDate.of(2022,06,22), solicitudFacturar.getFechaIngreso());
    }
}

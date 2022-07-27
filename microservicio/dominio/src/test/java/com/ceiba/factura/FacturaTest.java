package com.ceiba.factura;

import com.ceiba.cliente.ClienteTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.TipoCliente;
import com.ceiba.factura.modelo.entidad.EstadoFactura;
import com.ceiba.factura.modelo.entidad.ProductoFacturar;
import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaTest {

    @Test
    void deberiaConstruirUnaFacturaExitosamente(){
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();


        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruir();
        List<ProductoFacturar> productosFacturar = new ArrayList<>();
        productosFacturar.add(0,ProductoFacturar.crear(5,planta));



        var factura = new FacturaTestDataBuilder()

                .conId(1l)
                .conCliente(cliente)
                .conProductos(productosFacturar)
                .conValorTotal(new BigDecimal(120000))
                .conEstado(EstadoFactura.ACTIVA)
                .conFechaIngreso(LocalDate.of(2022,06,23))
                .conFechaDomicilio(LocalDate.of(2022,06,24))
                .reconstruir();
        Assertions.assertEquals(1l,factura.getId());
        Assertions.assertEquals(cliente, factura.getCliente());
        Assertions.assertEquals(productosFacturar, factura.getProductos());
        Assertions.assertEquals(new BigDecimal(120000), factura.getValorTotal());
        Assertions.assertEquals(EstadoFactura.ACTIVA, factura.getEstado());
        Assertions.assertEquals(LocalDate.of(2022,06,23), factura.getFechaIngreso());
        Assertions.assertEquals(LocalDate.of(2022,06,24), factura.getFechaDomicilio());

    }

    @Test
    void validarDiaFestivoExitosamente(){
        var factura = new FacturaTestDataBuilder().conFacturaPorDefecto()
                .reconstruir();
        factura.validarDiaFestivo(LocalDate.of(2022,06,27));
        Assertions.assertEquals(1l, factura.getId());
    }

    @Test
    void validarDiaHabilSiguienteExitosamente(){
        var factura = new FacturaTestDataBuilder().conFacturaPorDefecto()
                .reconstruir();
        LocalDate diaSiguiente = factura.validarSiguienteDiaHabil(LocalDate.of(2022,06,24));
        Assertions.assertEquals(LocalDate.of(2022,06,28), diaSiguiente);
    }

    @Test
    void validarAplicardescuentoExitosamente(){
        Cliente cliente2 = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .conTipoCliente(TipoCliente.ESPECIAL)
                .reconstruir();

        var factura = new FacturaTestDataBuilder().conFacturaPorDefecto()
                .conCliente(cliente2)
                .reconstruir();
        factura.aplicarDescuento();
        Assertions.assertEquals(BigDecimal.valueOf(108000.0), factura.getValorTotal());
    }

    @Test
    void validarCalcularValorTotalExitosamente(){
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();
        List<ProductoFacturar> productosFacturar = new ArrayList<>();
        productosFacturar.add(0,ProductoFacturar.crear(5,planta));

        var factura = new FacturaTestDataBuilder().conFacturaPorDefecto()
                .reconstruir();
        factura.calcularvalorTotal(productosFacturar);
        Assertions.assertEquals(BigDecimal.valueOf(120000),factura.getValorTotal() );
    }



}

package com.ceiba.planta;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlantaTest {

    @Test
    void deberiaReconstruirPlantaExitosamente() {
        var planta = new PlantaTestDataBuilder()
                .conId(123)
                .conNombre("Girasol")
                .conDescripcion("Color Amarillo")
                .conFechaIngreso(LocalDate.of(2022,06,22))
                .conCantidad(180)
                .conValor(new BigDecimal(15000))
                .conCategoria(CategoriaPlanta.PLANTASDEFLOR).
                reconstruir();

        Assertions.assertEquals(123, planta.getIdPlanta());
        Assertions.assertEquals("Girasol", planta.getNombre());
        Assertions.assertEquals("Color Amarillo", planta.getDescripcion());
        Assertions.assertEquals(LocalDate.of(2022,06,22), planta.getFechaIngreso());
        Assertions.assertEquals(180, planta.getCantidad());
        Assertions.assertEquals(new BigDecimal(15000),planta.getValor());
        Assertions.assertEquals(CategoriaPlanta.PLANTASDEFLOR, planta.getCategoria());
    }

    @Test
    void reconstruirSinNombreDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PlantaTestDataBuilder()
                        .conId(123)
                        .conDescripcion("Color Amarillo")
                        .conFechaIngreso(LocalDate.now())
                        .conCantidad(180)
                        .conValor(BigDecimal.valueOf(15000))
                        .conCategoria(CategoriaPlanta.valueOf("PLANTASDEFLOR")).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "El nombre de la planta es requerido");
    }
    @Test
    void reconstruirSinDescripcionDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PlantaTestDataBuilder()
                        .conId(123)
                        .conNombre("Girasol")
                        .conFechaIngreso(LocalDate.of(2022,05,22))
                        .conCantidad(180)
                        .conValor(BigDecimal.valueOf(15000))
                        .conCategoria(CategoriaPlanta.valueOf("PLANTASDEFLOR")).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "La descripcion de la planta es requerida");
    }
    @Test
    void reconstruirSinFechaIngresoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PlantaTestDataBuilder()
                        .conId(123)
                        .conNombre("Girasol")
                        .conDescripcion("Color Amarillo")
                        .conCantidad(180)
                        .conValor(BigDecimal.valueOf(15000))
                        .conCategoria(CategoriaPlanta.PLANTASDEFLOR).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "La fecha de ingreso de la planta es requerida");
    }
    @Test
    void reconstruirSinValorDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PlantaTestDataBuilder()
                        .conId(123)
                        .conNombre("Girasol")
                        .conDescripcion("Color Amarillo")
                        .conFechaIngreso(LocalDate.now())
                        .conCantidad(180)
                        .conCategoria(CategoriaPlanta.PLANTASDEFLOR).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "El valor  de la planta es requerido");
    }
    @Test
    void reconstruirSinCategoriaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new PlantaTestDataBuilder()
                        .conId(123)
                        .conNombre("Girasol")
                        .conDescripcion("Color Amarillo")
                        .conFechaIngreso(LocalDate.now())
                        .conCantidad(180)
                        .conValor(BigDecimal.valueOf(15000)).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "La categoria de la planta es requerida");
    }
    @Test
    void CalculaSabadoDomingoExitosamente(){
        BasePrueba.assertThrows(() -> new PlantaTestDataBuilder().conPlantaPorDefecto()
                        .reconstruir()
                        .calculaSabadoDomingo(LocalDate.of(2022,06,26))
                ,ExcepcionValorInvalido.class,
                "Hoy es fin de semana y no se puede recibir mercancia");

    }

}
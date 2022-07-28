package com.ceiba.planta;

import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import com.ceiba.proveedor.ProveedorTestDataBuilder;
import com.ceiba.proveedor.SolicitudProveedorTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SolicitudCrearPlantaTest {


        @Test
        void deberiaCrearPlantaExitosamente() {
            var planta = new SolicitudCrerPlantaTestDataBuilder()
                    .conId(123l)
                    .conNombre("Girasol")
                    .conDescripcion("Color Amarillo")
                    .conFechaIngreso(LocalDate.of(2022,06,22))
                    .conCantidad(180)
                    .conValor(new BigDecimal(15000))
                    .conCategoria(CategoriaPlanta.PLANTASDEFLOR).
                    reconstruir();

            Assertions.assertEquals(123, planta.getId());
            Assertions.assertEquals("Girasol", planta.getNombre());
            Assertions.assertEquals("Color Amarillo", planta.getDescripcion());
            Assertions.assertEquals(LocalDate.of(2022,06,22), planta.getFechaIngreso());
            Assertions.assertEquals(180, planta.getCantidad());
            Assertions.assertEquals(new BigDecimal(15000),planta.getValor());
            Assertions.assertEquals(CategoriaPlanta.PLANTASDEFLOR, planta.getCategoria());
        }


}

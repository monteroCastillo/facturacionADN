package com.ceiba.planta;


import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.planta.servicio.ServicioCrearPlanta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SolicitudCrearPlantaTest {


        @Test
        void deberiaCrearPlantaExitosamente() {
            Planta planta = new PlantaTestDataBuilder()
                    .conPlantaPorDefecto()
                    .reconstruir();

            var solicitudCrearPlanta = new SolicitudCrerPlantaTestDataBuilder()
                    .conId(123l)
                    .conNombre("Girasol")
                    .conDescripcion("Color Amarillo")
                    .conFechaIngreso(LocalDate.of(2022,06,22))
                    .conCantidad(180)
                    .conValor(new BigDecimal(15000))
                    .conCategoria(CategoriaPlanta.PLANTASDEFLOR).
                    construir();

            var repositorioPlanta = Mockito.mock(RepositorioPlanta.class);
            Mockito.when(repositorioPlanta.guardar(Mockito.any())).thenReturn(123L);

            var servicioPlanta = new ServicioCrearPlanta(repositorioPlanta);
            var idPlantaGuardado = servicioPlanta.ejecutar(solicitudCrearPlanta);

            ArgumentCaptor<Planta> captorPlanta = ArgumentCaptor.forClass(Planta.class);
            Mockito.verify(repositorioPlanta, Mockito.times(1)).guardar(captorPlanta.capture());

            Assertions.assertEquals(123l, idPlantaGuardado);
            Assertions.assertEquals("Girasol", captorPlanta.getValue().getNombre());
            Assertions.assertEquals("Color Amarillo", captorPlanta.getValue().getDescripcion());
            Assertions.assertEquals(LocalDate.of(2022,06,22), captorPlanta.getValue().getFechaIngreso());
            Assertions.assertEquals(180, captorPlanta.getValue().getCantidad());
            Assertions.assertEquals(new BigDecimal(15000),captorPlanta.getValue().getValor());
            Assertions.assertEquals(CategoriaPlanta.PLANTASDEFLOR, captorPlanta.getValue().getCategoria());
        }


}

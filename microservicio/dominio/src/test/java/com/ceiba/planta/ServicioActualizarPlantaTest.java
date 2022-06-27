package com.ceiba.planta;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.planta.servicio.ServicioActualizarPlanta;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ServicioActualizarPlantaTest {

    @Test
    public void validarActualizacionPlantaTest() {
        // arrange
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().build();
        RepositorioPlanta repositorioPlanta = Mockito.mock(RepositorioPlanta.class);
        Mockito.when(repositorioPlanta.existe(Mockito.anyInt())).thenReturn(true);
        ServicioActualizarPlanta servicioActualizarPlanta = new ServicioActualizarPlanta(repositorioPlanta);
        // act - assert
        servicioActualizarPlanta.ejecutar(planta);
        verify(repositorioPlanta,times(1)).actualizar(planta);
    }
}

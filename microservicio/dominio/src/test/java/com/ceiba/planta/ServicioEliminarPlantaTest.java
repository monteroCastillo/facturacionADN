package com.ceiba.planta;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.planta.servicio.ServicioEliminarPlanta;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarPlantaTest {

    @Test
    void deberiaEliminarPlantaTest(){
        Planta planta = new PlantaTestDataBuilder()
                .conId(1L)
                .conPlantaPorDefecto()
                .reconstruir();

        var repositorioPlanta = Mockito.mock(RepositorioPlanta.class);
        Mockito.when(repositorioPlanta.guardar(Mockito.any())).thenReturn(1L);

        var servicioPlanta = new ServicioEliminarPlanta(repositorioPlanta);
        servicioPlanta.ejecutar(planta.getId());

        Mockito.verify(repositorioPlanta,Mockito.times(1)).eliminar(planta.getId());
    }
}

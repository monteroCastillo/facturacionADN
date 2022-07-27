package com.ceiba.planta;


import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.planta.servicio.ServicioCrearPlanta;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearPlantaTest {
    @Test
    public void validarCreacionPlanta(){
        Long ID = 1l;
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().reconstruir();
        RepositorioPlanta repositorioPlanta = Mockito.mock(RepositorioPlanta.class);
        Mockito.when(repositorioPlanta.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPlanta.guardar(planta)).thenReturn(ID);
        ServicioCrearPlanta servicioCrearPlanta = new ServicioCrearPlanta(repositorioPlanta);
        // act - assert
       // assertEquals(ID,servicioCrearPlanta.ejecutar(planta));
       // BasePrueba.assertThrows(() -> servicioCrearPlanta.ejecutar(planta), ExcepcionValorInvalido.class, MensajesDeExcepcion.ES_FIN_DE_SEMANA.getMensaje());
    }
}

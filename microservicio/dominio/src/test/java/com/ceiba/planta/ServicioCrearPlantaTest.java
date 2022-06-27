package com.ceiba.planta;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.planta.servicio.ServicioCrearPlanta;
import com.ceiba.planta.utils.MensajesDeExcepcion;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPlantaTest {
    @Test
    public void validarCreacionPlanta(){
        int ID = 1;
        Planta planta = new PlantaTestDataBuilder().conPlantaPorDefecto().build();
        RepositorioPlanta repositorioPlanta = Mockito.mock(RepositorioPlanta.class);
        Mockito.when(repositorioPlanta.existe(Mockito.anyInt())).thenReturn(false);
        Mockito.when(repositorioPlanta.guardar(planta)).thenReturn(ID);
        ServicioCrearPlanta servicioCrearPlanta = new ServicioCrearPlanta(repositorioPlanta);
        // act - assert
        assertEquals(ID,servicioCrearPlanta.ejecutar(planta));
       // BasePrueba.assertThrows(() -> servicioCrearPlanta.ejecutar(planta), ExcepcionValorInvalido.class, MensajesDeExcepcion.ES_FIN_DE_SEMANA.getMensaje());
    }
}

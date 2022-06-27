package com.ceiba.plantaporproveedor;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.planta.utils.MensajesDeExcepcion;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.puerto.repositorio.RepositorioPlantaPorProveedor;
import com.ceiba.plantaporproveedor.servicio.ServicioCrearPlantaPorProveedor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPlantaPorProveedorTest {

    @Test
    public void validarCreacionPlantaPorProveedor(){
        Long ID = 1l;
        PlantaPorProveedor plantaPorProveedor = new PlantaPorProveedorTestDataBuilder().conPlantaPorProveedorPorDefecto().build();
        RepositorioPlantaPorProveedor repositorioPlantaPorProveedor = Mockito.mock(RepositorioPlantaPorProveedor.class);
        Mockito.when(repositorioPlantaPorProveedor.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPlantaPorProveedor.guardar(plantaPorProveedor)).thenReturn(ID);
        ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor = new ServicioCrearPlantaPorProveedor(repositorioPlantaPorProveedor);
        // act - assert
        assertEquals(ID,servicioCrearPlantaPorProveedor.ejecutar(plantaPorProveedor));

    }
}

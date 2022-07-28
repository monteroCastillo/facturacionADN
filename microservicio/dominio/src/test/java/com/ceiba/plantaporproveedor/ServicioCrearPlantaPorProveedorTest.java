package com.ceiba.plantaporproveedor;

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
        PlantaPorProveedor plantaPorProveedor = new PlantaPorProveedorTestDataBuilder().conPlantaPorProveedorPorDefecto().reconstruir();
        RepositorioPlantaPorProveedor repositorioPlantaPorProveedor = Mockito.mock(RepositorioPlantaPorProveedor.class);
        Mockito.when(repositorioPlantaPorProveedor.guardar(Mockito.any())).thenReturn(1l);
        var servicioCrearPlantaPorProveedor = new ServicioCrearPlantaPorProveedor(repositorioPlantaPorProveedor);
        var idPlantaPorProveedor = repositorioPlantaPorProveedor.guardar(plantaPorProveedor);
        // act - assert
        assertEquals(1l, idPlantaPorProveedor);

    }
}

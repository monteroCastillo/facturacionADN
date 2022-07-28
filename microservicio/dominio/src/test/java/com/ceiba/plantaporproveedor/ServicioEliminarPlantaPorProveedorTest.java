package com.ceiba.plantaporproveedor;

import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.puerto.repositorio.RepositorioPlantaPorProveedor;
import com.ceiba.plantaporproveedor.servicio.ServicioEliminarPlantaPorProveedor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarPlantaPorProveedorTest {
    @Test
    void deberiaEliminarPlantaPorProveedor(){
        PlantaPorProveedor plantaPorProveedor = new PlantaPorProveedorTestDataBuilder()
                .conId(1L)
                .conPlantaPorProveedorPorDefecto()
                .reconstruir();

        var repositorioPlantaPorProveedor = Mockito.mock(RepositorioPlantaPorProveedor.class);
        Mockito.when(repositorioPlantaPorProveedor.guardar(Mockito.any())).thenReturn(1L);

        var servicioPlantaPorProveedor = new ServicioEliminarPlantaPorProveedor(repositorioPlantaPorProveedor);
        servicioPlantaPorProveedor.ejecutar(plantaPorProveedor.getId());

        Mockito.verify(repositorioPlantaPorProveedor,Mockito.times(1)).eliminar(plantaPorProveedor.getId());
    }
}

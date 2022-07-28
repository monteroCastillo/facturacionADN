package com.ceiba.plantaporproveedor;


import com.ceiba.planta.PlantaTestDataBuilder;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.puerto.repositorio.RepositorioPlantaPorProveedor;
import com.ceiba.plantaporproveedor.servicio.ServicioCrearPlantaPorProveedor;
import com.ceiba.proveedor.ProveedorTestDataBuilder;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class SolicitudCrearPlataPorProveedorTest {

    @Test
    void deberiaRealizarLaSolicitudCrearPlantaPorProveedorTestExitosamente(){

        Proveedor proveedor = new ProveedorTestDataBuilder()
                .conProveedorPorDefecto()
                .reconstruir();

        Planta planta = new PlantaTestDataBuilder()
                .conPlantaPorDefecto()
                .reconstruir();

        var solicitudCrearPlantaPorProveedor = new SolicitudCrearPlantaPorProveedorTestDataBuilder()
                .conId(1l)
                .conProveedor(proveedor)
                .conPlanta(planta)
                .construir();

        var repositorioPlantaPorProveedor = Mockito.mock(RepositorioPlantaPorProveedor.class);
        Mockito.when(repositorioPlantaPorProveedor.guardar(Mockito.any())).thenReturn(1L);

        var servicioCrearPlantaPorProveedor = new ServicioCrearPlantaPorProveedor(repositorioPlantaPorProveedor);
        var idPlantaPorProveedorGuardado = servicioCrearPlantaPorProveedor.ejecutar(solicitudCrearPlantaPorProveedor);

        ArgumentCaptor<PlantaPorProveedor> captorPlantaPorProveedor = ArgumentCaptor.forClass(PlantaPorProveedor.class);
        Mockito.verify(repositorioPlantaPorProveedor,  Mockito.times(1)).guardar(captorPlantaPorProveedor.capture());


        Assertions.assertEquals(1l, idPlantaPorProveedorGuardado);
        Assertions.assertEquals(1l, captorPlantaPorProveedor.getValue().getProveedor().getId());
        Assertions.assertEquals(1l, captorPlantaPorProveedor.getValue().getProveedor().getId());

    }
}

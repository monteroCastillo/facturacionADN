package com.ceiba.configuracion;

import com.ceiba.empleado.servicio.ServicioActualizarEmpleado;
import com.ceiba.plantaPorProveedor.puerto.repositorio.RepositorioPlantaPorProveedor;
import com.ceiba.plantaPorProveedor.servicio.ServicioCrearPlantaPorProveedor;
import com.ceiba.plantaPorProveedor.servicio.ServicioEliminarPlantaPorProveedor;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioAnular;
import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.ServicioCrearEmpleado;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.planta.servicio.ServicioActualizarPlanta;
import com.ceiba.planta.servicio.ServicioCrearPlanta;
import com.ceiba.planta.servicio.ServicioEliminarPlanta;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import com.ceiba.proveedor.servicio.ServicioActualizarProveedor;
import com.ceiba.proveedor.servicio.ServicioCrearProveedor;
import com.ceiba.proveedor.servicio.ServicioEliminarProveedor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanServicio {


    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }

    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }

    @Bean
    public ServicioCrearEmpleado servicioCrearPersona(RepositorioEmpleado repositorioEmpleado){
        return new ServicioCrearEmpleado(repositorioEmpleado);
    }

    @Bean
    ServicioActualizarEmpleado servicioActualizarEmpleado(RepositorioEmpleado repositorioEmpleado){
        return  new ServicioActualizarEmpleado(repositorioEmpleado);
    }

    @Bean
    public ServicioCrearPlanta servicioCrearPlanta(RepositorioPlanta repositorioPlanta){
        return new ServicioCrearPlanta(repositorioPlanta);
    }
    @Bean
    public ServicioEliminarPlanta servicioEliminarPlanta(RepositorioPlanta repositorioPlanta){
        return new ServicioEliminarPlanta(repositorioPlanta);
    }
    @Bean
    public ServicioActualizarPlanta servicioActualizarPlanta(RepositorioPlanta repositorioPlanta){
        return new ServicioActualizarPlanta(repositorioPlanta);
    }

    @Bean
    public ServicioCrearProveedor servicioCrearProveedor(RepositorioProveedor repositorioProveedor){
        return  new ServicioCrearProveedor(repositorioProveedor);
    }
    @Bean
    public ServicioEliminarProveedor servicioEliminarProveedor(RepositorioProveedor repositorioProveedor){
        return new ServicioEliminarProveedor(repositorioProveedor);
    }
    @Bean
    public ServicioActualizarProveedor servicioActualizarProveedor(RepositorioProveedor repositorioProveedor){
        return new ServicioActualizarProveedor(repositorioProveedor);
    }

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente){
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor(RepositorioPlantaPorProveedor repositorioPlantaPorProveedor){
        return new ServicioCrearPlantaPorProveedor(repositorioPlantaPorProveedor);
    }

    @Bean
    public ServicioEliminarPlantaPorProveedor servicioEliminarPlantaPorProveedor(RepositorioPlantaPorProveedor repositorioPlantaPorProveedor){
        return new ServicioEliminarPlantaPorProveedor(repositorioPlantaPorProveedor);
    }
}

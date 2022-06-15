package com.ceiba.configuracion;

import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioAnular;
import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import com.ceiba.planta.servicio.ServicioCrearPlanta;
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
    public ServicioCrearPersona servicioCrearPersona(RepositorioPersona repositorioPersona){
        return new ServicioCrearPersona(repositorioPersona);
    }

    @Bean
    public ServicioCrearPlanta servicioCrearPlanta(RepositorioPlanta repositorioPlanta){
        return new ServicioCrearPlanta(repositorioPlanta);
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

}

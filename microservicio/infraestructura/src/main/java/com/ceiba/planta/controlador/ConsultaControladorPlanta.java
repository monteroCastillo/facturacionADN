package com.ceiba.planta.controlador;

import com.ceiba.planta.comando.manejador.ManejadorBuscarPlanta;
import com.ceiba.planta.comando.manejador.ManejadorPlantaProveedor;
import com.ceiba.planta.consulta.ManejadorListarPlantas;
import com.ceiba.planta.modelo.entidad.Planta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plantas")
public class ConsultaControladorPlanta {

    private final ManejadorListarPlantas manejadorListarPlantas;
    private final ManejadorBuscarPlanta manejadorBuscarPlanta;

    private final ManejadorPlantaProveedor manejadorPlantaProveedor;

    public ConsultaControladorPlanta(ManejadorListarPlantas manejadorListarPlantas, ManejadorBuscarPlanta manejadorBuscarPlanta, ManejadorPlantaProveedor manejadorPlantaProveedor) {
        this.manejadorListarPlantas = manejadorListarPlantas;
        this.manejadorBuscarPlanta = manejadorBuscarPlanta;
        this.manejadorPlantaProveedor = manejadorPlantaProveedor;
    }


    @GetMapping("/index")
    public List<Planta> listar(){
        return  this.manejadorListarPlantas.ejecutar();}

    @GetMapping({"/buscar/{id}"})
    public Planta buscar(@PathVariable("id") int id) {
        return this.manejadorBuscarPlanta.ejecutar(id);
    }

    @GetMapping({"/consulta/{id}"})
    public List<Planta> buscarPlantaProveedor(@PathVariable("id") Long id) {
        return this.manejadorPlantaProveedor.ejecutar(id);
    }
}

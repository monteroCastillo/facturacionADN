package com.ceiba.planta.controlador;

import com.ceiba.planta.consulta.ManejadorListarPlantas;
import com.ceiba.planta.modelo.dto.DtoPlanta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class ConsultaControladorPlanta {

    private final ManejadorListarPlantas manejadorListarPlantas;


    public ConsultaControladorPlanta(ManejadorListarPlantas manejadorListarPlantas) {
        this.manejadorListarPlantas = manejadorListarPlantas;
    }

    @GetMapping("/plantas")
    public List<DtoPlanta> listar(){
        return  this.manejadorListarPlantas.ejecutar();}

}

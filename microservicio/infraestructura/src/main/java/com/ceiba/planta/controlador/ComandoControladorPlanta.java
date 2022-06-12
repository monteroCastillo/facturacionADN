package com.ceiba.planta.controlador;


import com.ceiba.planta.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiPlanta")
public class ComandoControladorPlanta {
//    @Autowired
//    private RepositorioPlanta servicioPlanta;
//
//    @GetMapping("/index")
//    public List<Planta> buscarTodos(){
//        System.out.println("Entro al controlador = " );
//        return servicioPlanta.buscarTodos();
//    }
//
//    @PostMapping("/planta")
//    public Planta guardar(@RequestBody Planta planta){
//        servicioPlanta.guardar(planta);
//        return planta;
//    }

}

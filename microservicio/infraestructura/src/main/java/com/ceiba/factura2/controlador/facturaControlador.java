package com.ceiba.factura2.controlador;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiFactura")
public class facturaControlador {

    @GetMapping({"/index"})
    void  buscarTodos() {

    }
}
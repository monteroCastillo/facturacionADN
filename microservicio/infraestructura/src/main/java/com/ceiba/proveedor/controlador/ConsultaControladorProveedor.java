package com.ceiba.proveedor.controlador;

import com.ceiba.proveedor.comando.manejador.ManejadorBuscarProveedor;
import com.ceiba.proveedor.consulta.ManejadorListarProveedores;
import com.ceiba.proveedor.modelo.dto.DtoProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ConsultaControladorProveedor {

    private final ManejadorListarProveedores manejadorListarProveedores;
    private final ManejadorBuscarProveedor manejadorBuscarProveedor;

    public ConsultaControladorProveedor(ManejadorListarProveedores manejadorListarProveedores, ManejadorBuscarProveedor manejadorBuscarProveedor) {
        this.manejadorListarProveedores = manejadorListarProveedores;
        this.manejadorBuscarProveedor = manejadorBuscarProveedor;
    }


    @GetMapping("/index")
    public List<Proveedor> listar(){
        return this.manejadorListarProveedores.ejecutar();}

    @GetMapping({"/buscar/{id}"})
    public Proveedor buscar(@PathVariable("id") Long id) {
        return this.manejadorBuscarProveedor.ejecutar(id);
    }


}

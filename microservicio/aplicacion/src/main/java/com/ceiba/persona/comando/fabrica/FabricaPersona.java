package com.ceiba.persona.comando.fabrica;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Persona crear(ComandoPersona comandoPersona){
        return new Persona(
                comandoPersona.getIdPersona(),
                comandoPersona.getNombre(),
                comandoPersona.getDireccion(),
                comandoPersona.getTelefono(),
                comandoPersona.getEmail(),
                comandoPersona.getFechaRegistro()
        );
    }





//    private final RepositorioPersona repositorioPersona;
//
//    public FabricaSolicitudCrearPersona(RepositorioPersona repositorioPersona){
//        this.repositorioPersona = repositorioPersona;
//    }
//
//    public SolicitudCrearPersona crear(ComandoPersona comandoPersona) {
//        return new SolicitudCrearPersona(repositorioPersona.obtener(comandoPersona.getIdPersona()));
//
//
//    }

//    private List<ProductoFacturar> obtenerProductos(List<ComandoProductoFacturar> comandoProductosFacturar) {
//        return comandoProductosFacturar.stream().map(comandoProducto ->
//                        ProductoFacturar.crear(
//                                comandoProducto.getCantidad(),
//                                repositorioPersona.obtener(comandoProducto.getIdProducto())))
//                .toList();
//    }

}

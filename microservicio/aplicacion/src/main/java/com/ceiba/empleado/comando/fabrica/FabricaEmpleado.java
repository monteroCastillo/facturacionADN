package com.ceiba.empleado.comando.fabrica;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.modelo.entidad.SolicitudCrearEmpleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import org.springframework.stereotype.Component;

@Component
public class FabricaEmpleado{

    private final RepositorioEmpleado repositorioEmpleado;

    public FabricaEmpleado(RepositorioEmpleado repositorioEmpleado) {this.repositorioEmpleado = repositorioEmpleado;}
    public SolicitudCrearEmpleado guardarEmpleado(ComandoEmpleado comandoEmpleado){
        return new SolicitudCrearEmpleado(comandoEmpleado.getIdEmpleado(), comandoEmpleado.getNombre(), comandoEmpleado.getDireccion(), comandoEmpleado.getTelefono(), comandoEmpleado.getEmail(), comandoEmpleado.getFechaRegistro(),comandoEmpleado.getPerfil());
    }


}

package com.ceiba.empleado.comando.fabrica;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.modelo.entidad.SolicitudCrearEmpleado;
import org.springframework.stereotype.Component;

@Component
public class FabricaEmpleado{


    public SolicitudCrearEmpleado guardarEmpleado(ComandoEmpleado comandoEmpleado){
        return new SolicitudCrearEmpleado(comandoEmpleado.getIdEmpleado(), comandoEmpleado.getNombre(), comandoEmpleado.getDireccion(), comandoEmpleado.getTelefono(), comandoEmpleado.getEmail(), comandoEmpleado.getFechaRegistro(),comandoEmpleado.getPerfil());
    }


}

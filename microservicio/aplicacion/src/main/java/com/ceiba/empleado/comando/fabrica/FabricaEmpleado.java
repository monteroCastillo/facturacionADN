package com.ceiba.empleado.comando.fabrica;

import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.modelo.entidad.Empleado;
import org.springframework.stereotype.Component;

@Component
public class FabricaEmpleado {

    public Empleado crear(ComandoEmpleado comandoEmpleado){

        return new Empleado(
                comandoEmpleado.getIdEmpleado(),
                comandoEmpleado.getNombre(),
                comandoEmpleado.getDireccion(),
                comandoEmpleado.getTelefono(),
                comandoEmpleado.getEmail(),
                comandoEmpleado.getFechaRegistro(),
                comandoEmpleado.getPerfil()
        );
    }


}

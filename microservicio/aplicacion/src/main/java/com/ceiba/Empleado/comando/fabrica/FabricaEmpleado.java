package com.ceiba.Empleado.comando.fabrica;

import com.ceiba.Empleado.comando.ComandoEmpleado;
import com.ceiba.Empleado.modelo.entidad.Empleado;
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

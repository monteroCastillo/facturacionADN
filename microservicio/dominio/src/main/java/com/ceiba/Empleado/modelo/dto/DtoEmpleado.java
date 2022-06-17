package com.ceiba.Empleado.modelo.dto;

import com.ceiba.Empleado.modelo.entidad.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEmpleado {
    private final Long idEmpleado;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String email;
    private final LocalDate fechaRegistro;
    private Perfil perfil;
}

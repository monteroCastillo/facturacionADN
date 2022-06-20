package com.ceiba.empleado.modelo.dto;

import com.ceiba.empleado.modelo.entidad.Perfil;
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

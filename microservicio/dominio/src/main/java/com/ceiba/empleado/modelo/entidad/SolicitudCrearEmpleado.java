package com.ceiba.empleado.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class SolicitudCrearEmpleado {

    private Long idEmpleado;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;
    private Perfil perfil;
}

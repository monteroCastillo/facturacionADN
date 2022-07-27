package com.ceiba.empleado;

import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.Perfil;

import java.time.LocalDate;

public class ComandoEmpleadoTestDataBuilder {

    private Long idEmpleado;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;
    private Perfil perfil;

    public ComandoEmpleadoTestDataBuilder(){
        this.idEmpleado = 1L;
        this.nombre = "Laura";
        this.direccion = "Av 6";
        this.telefono = "5555";
        this.email = "Laura@hotmail.com";
        this.fechaRegistro = LocalDate.now();
        this.perfil = Perfil.ADMINISTRADOR;
    }

    public Empleado reconstruir(){
    return Empleado.reconstruir(idEmpleado, nombre, direccion, telefono, email,fechaRegistro, perfil);
    }
}

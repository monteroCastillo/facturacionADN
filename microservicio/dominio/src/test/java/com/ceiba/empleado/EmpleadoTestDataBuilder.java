package com.ceiba.empleado;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.Perfil;

import java.time.LocalDate;

public class EmpleadoTestDataBuilder {
    private Long idEmpleado;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;
    private Perfil perfil;

    public EmpleadoTestDataBuilder conEmpleadoPorDefecto() {
        this.idEmpleado = 123l;
        this.nombre = "Shirley";
        this.direccion = "Av 6";
        this.telefono = "4545456";
        this.email = "shi@gmail.com";
        this.fechaRegistro = LocalDate.of(2022,05,22);
        this.perfil = Perfil.ADMINISTRADOR;
        return this;
    }

    public EmpleadoTestDataBuilder conId(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
        return this;
    }

    public EmpleadoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpleadoTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public EmpleadoTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public EmpleadoTestDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public EmpleadoTestDataBuilder conFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        return this;
    }

    public EmpleadoTestDataBuilder conPerfil(Perfil perfil) {
        this.perfil = perfil;
        return this;
    }

    public Empleado reconstruir(){
        return  Empleado.reconstruir(idEmpleado,nombre,direccion,telefono,email,fechaRegistro,perfil);
    }

}

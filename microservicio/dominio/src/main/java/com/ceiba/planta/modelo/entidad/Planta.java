package com.ceiba.planta.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.planta.utils.MensajesDeExcepcion;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
@SuppressWarnings("java:S2974")
public class Planta {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
    private int cantidad;
    private  BigDecimal valor;
    private CategoriaPlanta categoria;

    private Planta(Long id, String nombre, String descripcion, LocalDate fechaIngreso, int cantidad, BigDecimal valor, CategoriaPlanta categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        calculaSabadoDomingo(fechaIngreso);
        this.cantidad = cantidad;
        this.valor = valor;
        this.categoria = categoria;
    }
    private Planta( String nombre, String descripcion, LocalDate fechaIngreso, int cantidad, BigDecimal valor, CategoriaPlanta categoria) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        calculaSabadoDomingo(fechaIngreso);
        this.cantidad = cantidad;
        this.valor = valor;
        this.categoria = categoria;
    }

    public static Planta reconstruir(Long id, String nombre, String descripcion, LocalDate fechaIngreso, int cantidad, BigDecimal valor, CategoriaPlanta categoria){
        ValidadorArgumento.validarObligatorio(id, "El id de la planta es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre de la planta es requerido");
        ValidadorArgumento.validarObligatorio(descripcion, "La descripcion de la planta es requerida");
        ValidadorArgumento.validarObligatorio(fechaIngreso, "La fecha de ingreso de la planta es requerida");
        ValidadorArgumento.validarObligatorio(cantidad, "La cantidad de plantas es requerida");
        ValidadorArgumento.validarObligatorio(valor, "El valor  de la planta es requerido");
        ValidadorArgumento.validarObligatorio(categoria, "La categoria de la planta es requerida");
        return new Planta(id, nombre, descripcion,fechaIngreso,cantidad, valor, categoria);
    }

    public static Planta crear(SolicitudCrearPlanta solicitudCrearPlanta){
        ValidadorArgumento.validarObligatorio(solicitudCrearPlanta.getNombre(), "El nombre de la planta es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearPlanta.getDescripcion(), "La descripcion de la planta es requerida");
        ValidadorArgumento.validarObligatorio(solicitudCrearPlanta.getFechaIngreso(), "La fecha de ingreso de la planta es requerida");
        ValidadorArgumento.validarObligatorio(solicitudCrearPlanta.getCantidad(), "La cantidad de plantas es requerida");
        ValidadorArgumento.validarObligatorio(solicitudCrearPlanta.getValor(), "El valor  de la planta es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearPlanta.getCategoria(), "La categoria de la planta es requerida");

        return new Planta(solicitudCrearPlanta.getNombre(), solicitudCrearPlanta.getDescripcion(), solicitudCrearPlanta.getFechaIngreso(), solicitudCrearPlanta.getCantidad(), solicitudCrearPlanta.getValor(), solicitudCrearPlanta.getCategoria());
    }

    public void calculaSabadoDomingo(LocalDate result) {

        if ((result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)){
            throw new ExcepcionValorInvalido(MensajesDeExcepcion.ES_FIN_DE_SEMANA.getMensaje());
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public CategoriaPlanta getCategoria() {
        return categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }


}

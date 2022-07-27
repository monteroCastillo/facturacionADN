package com.ceiba.planta.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class SolicitudCrearPlanta {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
    private int cantidad;
    private BigDecimal valor;
    private CategoriaPlanta categoria;
}

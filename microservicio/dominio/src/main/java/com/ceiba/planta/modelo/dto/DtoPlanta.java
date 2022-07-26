package com.ceiba.planta.modelo.dto;

import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoPlanta {

    private final Long id;
    private final String nombre;
    private final String descripcion;
    private final LocalDate fechaIngreso;
    private final int cantidad;
    private final BigDecimal valor;
    private final CategoriaPlanta categoria;

    
}

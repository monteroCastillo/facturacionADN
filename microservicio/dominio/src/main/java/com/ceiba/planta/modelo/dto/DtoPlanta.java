package com.ceiba.planta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoPlanta {

    private final int idPlanta;
    private final String nombre;
    private final String descripcion;
    private final LocalDate fechaIngreso;

    
}

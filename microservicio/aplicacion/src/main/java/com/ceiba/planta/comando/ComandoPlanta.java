package com.ceiba.planta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPlanta {
    private int idPlanta;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
}

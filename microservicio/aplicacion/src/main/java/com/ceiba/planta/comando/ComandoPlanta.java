package com.ceiba.planta.comando;

import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    private int cantidad;
    private BigDecimal valor;
    private CategoriaPlanta categoria;

}

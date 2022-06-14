package com.ceiba.persona.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPersona {
    private Long idPersona;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;


}

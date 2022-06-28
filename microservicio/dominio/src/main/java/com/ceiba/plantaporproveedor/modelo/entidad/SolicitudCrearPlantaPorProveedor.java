package com.ceiba.plantaporproveedor.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SolicitudCrearPlantaPorProveedor {
    private final Long idProveedor;
    private final int idPlanta;

}

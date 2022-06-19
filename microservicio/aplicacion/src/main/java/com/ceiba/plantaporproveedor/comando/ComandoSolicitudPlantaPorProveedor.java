package com.ceiba.plantaporproveedor.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudPlantaPorProveedor {
    private Long idProveedor;
    private int idPlanta;
}

package com.ceiba.plantaporproveedor.modelo.entidad;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SolicitudCrearPlantaPorProveedor {
    private final Long id;
    private final Proveedor proveedor;
    private final Planta planta;

}

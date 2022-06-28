package com.ceiba.plantaporproveedor.comando;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPlantaPorProveedor {
    private Long id;
    private Long idProveedor;
    private int idPlanta;


}

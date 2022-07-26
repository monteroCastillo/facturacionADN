package com.ceiba.planta.puerto.repositorio;

import com.ceiba.planta.modelo.entidad.Planta;

public interface RepositorioPlanta {

    Long guardar(Planta planta);

    void eliminar(Long id);

    boolean existe(Long id);

    void actualizar(Planta planta);


}

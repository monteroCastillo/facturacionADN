package com.ceiba.planta.puerto.repositorio;

import com.ceiba.planta.modelo.entidad.Planta;

public interface RepositorioPlanta {

    int guardar(Planta planta);

    void eliminar(int idPlanta);

    boolean existe(int id);

    void actualizar(Planta planta);


}

package com.ceiba.cliente.puerto.repositorio;


import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    Cliente obtener(Long id);

    void eliminar(Long id);

    Long guardar(Cliente cliente);

    boolean existe(Long id);

}

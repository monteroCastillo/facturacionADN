update proveedor
set nombre = :nombre,
    direccion = :direccion,
    telefono = :telefono,
    paginaWeb = :paginaWeb
where id = :id;
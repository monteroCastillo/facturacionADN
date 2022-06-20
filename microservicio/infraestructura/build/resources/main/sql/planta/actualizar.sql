update planta
set nombre = :nombre,
    descripcion = :descripcion,
    fecha_ingreso = :fecha_ingreso,
    cantidad = :cantidad,
    valor = :valor,
    categoria = :categoria
where id = :id;
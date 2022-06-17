update planta
set nombre = :nombre,
    descripcion = :descripcion,
    fecha_ingreso = :fecha_ingreso,
    cantidad = :cantidad,
    categoria = :categoria
where id = :id;
update planta
set nombre = :nombre,
    descripcion = :descripcion,
    fecha_ingreso = :fecha_ingreso
where id = :id;
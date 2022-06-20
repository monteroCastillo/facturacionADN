update empleado
set nombre = :nombre,
    direccion = :direccion,
    telefono = :telefono,
    email = :email,
    fecha_registro = :fecha_registro,
    perfil = :perfil
where id = :id;
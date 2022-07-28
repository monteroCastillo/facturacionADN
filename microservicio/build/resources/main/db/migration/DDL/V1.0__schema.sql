create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 direccion varchar(100) not null,
 telefono varchar(50) not null,
 email varchar(100) not null,
 tipo_cliente varchar(20) not null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 aplica_iva TINYINT not null,
 valor DECIMAL(10,2) not null,
 primary key (id)
);

create table factura (
 id int(11) not null auto_increment,
 id_cliente int(11) not null,
 valor_total DECIMAL(10,2) not null,
 estado varchar(20) not null,
 fecha  DATE not null,
 fecha_domicilio DATE not null,
 primary key (id)
);

create table producto_facturar (
 id int(11) not null auto_increment,
 id_factura int(11) not null,
 id_planta int(11) not null,
 cantidad int(11) not null,
 primary key (id)
);

create table empleado (
   id int(11) not null auto_increment,
   nombre varchar(20) not null,
   direccion varchar(20) not null,
   telefono varchar(20) not null,
   email varchar(20) not null,
   fecha_registro DATE,
   perfil varchar(60),
   primary key (id)
);

create table planta(
    id int(11) not null auto_increment,
    nombre varchar(50) not null,
    descripcion varchar(200) not null,
    fecha_ingreso DATE not null,
    cantidad int(10) not null,
    valor DECIMAL(10,2) not null,
    categoria varchar(500)not null,
    primary key (id)

);


create table proveedor(
   id int(11) not null auto_increment,
   nombre varchar(50) not null,
   direccion varchar(50) not null,
   telefono varchar(30) not null,
   paginaWeb varchar(100) not null,
   primary key (id)
);

create table plantaporproveedor(
    id int(11)  auto_increment,
    id_proveedor int(11) ,
    id_planta int(11) ,
    primary key (id),
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id),
    FOREIGN KEY (id_planta) REFERENCES planta(id)
    ON UPDATE  CASCADE
    ON DELETE CASCADE
);

ALTER TABLE factura
ADD CONSTRAINT cliente_fk
  FOREIGN KEY (id_cliente)
  REFERENCES cliente (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT planta_fk
  FOREIGN KEY (id_planta)
  REFERENCES planta (id)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT factura_fk
  FOREIGN KEY (id_factura)
  REFERENCES factura (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
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
 primary key (id)
);

create table producto_facturar (
 id int(11) not null auto_increment,
 id_factura int(11) not null,
 id_producto int(11) not null,
 cantidad int(11) not null,
 primary key (id)
);

create table factura2 (
 id int(11) not null auto_increment,
 total int(11) not null,
 primary key (id)
);



create table persona (
   id_persona int(11) not null auto_increment,
   nombre varchar(20) not null,
   direccion varchar(20) not null,
   telefono varchar(20) not null,
   email varchar(20) not null,
   fecha_registro DATE,
   primary key (id_persona)
);

create table planta(
    id_planta int(11),
    nombre varchar(50),
    descripcion varchar(50),
    fecha_ingreso DATE,
    primary key (id_planta)
);


ALTER TABLE factura
ADD CONSTRAINT cliente_fk
  FOREIGN KEY (id_cliente)
  REFERENCES cliente (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT producto_fk
  FOREIGN KEY (id_producto)
  REFERENCES producto (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT factura_fk
  FOREIGN KEY (id_factura)
  REFERENCES factura (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
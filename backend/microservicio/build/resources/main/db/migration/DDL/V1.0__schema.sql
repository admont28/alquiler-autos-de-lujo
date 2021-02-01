create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime NULL DEFAULT now(),
 primary key (id)
);

create table auto (
 id int(11) not null auto_increment,
 serial varchar(100) NOT NULL,
 nombre varchar(100) not null,
 modelo varchar(45) not null,
 precio_dia decimal(10,2) not null,
 -- estado enum('DISPONIBLE', 'ELIMINADO', 'ALQUILADO', 'MANTENIMIENTO') not null default 'DISPONIBLE',
 estado varchar(100) NOT NULL DEFAULT 'DISPONIBLE',
 fecha_creacion datetime NULL DEFAULT now(),
 primary key (id)
);

create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) NOT NULL,
 apellido varchar(100) not null,
 direccion varchar(256) not null,
 cedula varchar(100) not null,
 --estado enum('ACTIVO', 'ELIMINADO') not NULL DEFAULT 'ACTIVO',
 estado varchar(100) NOT NULL DEFAULT 'ACTIVO',
 fecha_creacion datetime NULL DEFAULT now(),
 primary key (id)
);

create table alquiler (
 id int(11) not null auto_increment,
 auto_id int(11) NOT NULL,
 cliente_id int(11) not null,
 sub_total decimal(10,2) not null,
 descuento decimal(10,2) not null,
 total decimal(10,2) NOT NULL,
 fecha_alquiler date not NULL,
 fecha_devolucion date not NULL,
 fecha_creacion datetime NULL DEFAULT now(),
 primary key (id),
 CONSTRAINT FK_auto FOREIGN KEY (auto_id) REFERENCES auto(id),
 CONSTRAINT FK_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);




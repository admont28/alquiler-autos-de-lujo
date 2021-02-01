create table auto (
 id int(11) not null auto_increment,
 serial varchar(100) NOT NULL,
 nombre varchar(100) not null,
 modelo varchar(45) not null,
 precio_dia decimal(10,2) not null,
 estado enum('DISPONIBLE', 'ELIMINADO', 'ALQUILADO') not null,
 fecha_creacion datetime null,
 primary key (id)
);
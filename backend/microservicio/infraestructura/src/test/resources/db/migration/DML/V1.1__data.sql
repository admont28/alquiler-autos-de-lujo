insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

INSERT INTO auto
(id, serial, nombre, modelo, precio_dia, estado, fecha_creacion)
VALUES(1, 'serial-4321', 'BMW I3', '2021', 120000.00, 'DISPONIBLE', '2021-01-30 23:15:00');

INSERT INTO auto
(id, serial, nombre, modelo, precio_dia, estado, fecha_creacion)
VALUES(2, 'serial-1234', 'Chevrolet Corvette ', '2020', 200000.00, 'DISPONIBLE', now());

INSERT INTO cliente
(id, nombre, apellido, direccion, cedula, estado, fecha_creacion)
VALUES(1, 'Andres David', 'Montoya Aguirre', 'Calle 39 #5-72', '1094937274', 'ELIMINADO', '2021-02-01 15:20:53');

INSERT INTO cliente
(id, nombre, apellido, direccion, cedula, estado, fecha_creacion)
VALUES(2, 'Valentina', 'Giraldo', 'Calle 39', '1094951616', 'ACTIVO', now());

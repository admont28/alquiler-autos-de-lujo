INSERT INTO auto
(id, serial, nombre, modelo, precio_dia, estado, url_imagen, fecha_creacion)
VALUES(1, 'serial-4321', 'BMW I3', '2021', 120000.00, 'DISPONIBLE', 'https://alquilerautosdelujo.blob.core.windows.net/upload/2d79f993-39a6-4811-92a2-18a13a92c80c', '2021-01-30 23:15:00');

INSERT INTO auto
(id, serial, nombre, modelo, precio_dia, estado, url_imagen, fecha_creacion)
VALUES(2, 'serial-1234', 'Chevrolet Corvette', '2020', 200000.00, 'DISPONIBLE', 'https://alquilerautosdelujo.blob.core.windows.net/upload/2d79f993-39a6-4811-92a2-18a13a92c80c', '2021-01-31 08:15:00');

INSERT INTO auto
(id, serial, nombre, modelo, precio_dia, estado, url_imagen, fecha_creacion)
VALUES(3, 'serial-1', 'Chevrolet Spark', '2021', 150000.00, 'DISPONIBLE', 'https://alquilerautosdelujo.blob.core.windows.net/upload/2d79f993-39a6-4811-92a2-18a13a92c80c', '2021-01-31 08:15:00');

INSERT INTO cliente
(id, nombre, apellido, direccion, cedula, estado, fecha_creacion)
VALUES(1, 'Andres David', 'Montoya Aguirre', 'Calle 39 #5-72', '1094937274', 'ACTIVO', '2021-02-01 15:20:53');

INSERT INTO cliente
(id, nombre, apellido, direccion, cedula, estado, fecha_creacion)
VALUES(2, 'Valentina', 'Giraldo', 'Calle 39', '1094951616', 'ACTIVO', '2021-02-05 18:10:53');

INSERT INTO cliente
(id, nombre, apellido, direccion, cedula, estado, fecha_creacion)
VALUES(3, 'Maria Idalia', 'Aguirre Chica', 'Barrio el prado', '24481888', 'ACTIVO', '2021-02-05 18:10:53');

INSERT INTO alquiler
(id, auto_id, cliente_id, sub_total, descuento, total, fecha_alquiler, fecha_devolucion, fecha_creacion)
VALUES(1, 1, 1, 2280000.00, 182400.00, 2097600.00, '2021-01-01', '2021-01-20', '2021-01-01 08:21:16');

INSERT INTO alquiler
(id, auto_id, cliente_id, sub_total, descuento, total, fecha_alquiler, fecha_devolucion, fecha_creacion)
VALUES(2, 2, 2, 2280000.00, 182400.00, 2097600.00, '2021-01-05', '2021-01-25', '2021-01-05 07:00:00');

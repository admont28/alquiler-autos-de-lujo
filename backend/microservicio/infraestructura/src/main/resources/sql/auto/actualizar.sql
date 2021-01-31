update auto
set serial = :serial
	nombre = :nombre,
	modelo = :modelo,
	precio_dia = :precioPorDia
	fecha_creacion = :fechaCreacion
where id = :id
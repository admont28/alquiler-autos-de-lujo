update auto
set serial = :serial,
	nombre = :nombre,
	modelo = :modelo,
	precio_dia = :precioPorDia,
	estado = :estado
where id = :id
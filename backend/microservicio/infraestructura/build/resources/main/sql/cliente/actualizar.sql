UPDATE cliente
SET nombre = :nombre, 
	apellido = :apellido, 
	direccion = :direccion, 
	cedula = :cedula, 
	estado = :estado
WHERE id = :id
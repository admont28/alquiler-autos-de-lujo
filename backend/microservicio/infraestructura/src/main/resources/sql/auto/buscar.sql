SELECT id, serial, nombre, modelo, precio_dia, estado, url_imagen, fecha_creacion
FROM auto
WHERE id = :id

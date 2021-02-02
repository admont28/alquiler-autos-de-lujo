SELECT id, auto_id, cliente_id, sub_total, descuento, total, fecha_alquiler, fecha_devolucion, fecha_creacion
FROM alquiler
WHERE id = :id


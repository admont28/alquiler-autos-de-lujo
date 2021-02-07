select 
alquiler.id as alquiler_id, alquiler.sub_total as alquiler_sub_total, alquiler.descuento as alquiler_descuento, alquiler.total as alquiler_total, alquiler.fecha_alquiler as alquiler_fecha_alquiler, alquiler.fecha_devolucion as alquiler_fecha_devolucion, alquiler.fecha_creacion as alquiler_fecha_creacion, 
auto.id as auto_id, auto.serial as auto_serial, auto.nombre as auto_nombre, auto.modelo as auto_modelo, auto.precio_dia as auto_precio_dia, auto.estado as auto_estado, auto.fecha_creacion as auto_fecha_creacion, 
cliente.id as cliente_id, cliente.nombre as cliente_nombre, cliente.apellido as cliente_apellido, cliente.direccion as cliente_direccion, cliente.cedula as cliente_cedula, cliente.estado as cliente_estado, cliente.fecha_creacion as cliente_fecha_creacion
from alquiler alquiler, auto auto, cliente cliente
where
alquiler.auto_id = auto.id 
and alquiler.cliente_id = cliente.id 
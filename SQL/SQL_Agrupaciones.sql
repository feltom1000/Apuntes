SELECT sum(precio_actual * stock) AS 'Precio Total de Productos en Stock'
FROM productos

--Cantidad de vendedores que ingresaron x año
SELECT count(*), strftime('%Y', fecha_ingreso) AS 'año_ingreso'
FROM vendedores
GROUP BY 'año_ingreso'

--Cantidad de Vendedores por sucursal
SELECT sucursales.nombre, count(*) AS 'cantidad vendedores'
FROM vendedores
JOIN sucursales ON sucursales.id = vendedores.sucursal_id
GROUP BY sucursal

--Cantidad de Ventas x sucursal
SELECT sucursales.nombre, count(*) AS 'cantidad ventas'
FROM Ventas
JOIN vendedores ON vendedores.id = ventas.id_vendedor
JOIN sucursales ON sucursales.id = vendedores.sucursal
GROUP BY sucursales.id

-- Cantidad de Ventas por cada vendedor por cada sucursal
SELECT sucursales.nombre, vendedores.nombre, count(*) AS 'cantidad ventas'
FROM ventas
JOIN vendedores ON vendedores.id = ventas.id_vendedor
JOIN sucursales ON sucursales.id = vendedores.sucursal
GROUP BY vendedores.id, sucursales.id
ORDER BY sucursales.id

-- stock de productos vendidos por nombre de producto
SELECT productos.nombre, sum(ventas_productos.cantidad) AS 'cantidad'
FROM ventas_productos
JOIN productos ON productos.id = ventas_productos.id_producto
GROUP BY productos.id
ORDER BY producto.nombre

-- Calcular costos totales de ventas Y ACTUALIZARLO EN LA CELDA
SELECT ventas.id, sum(productos.precio_actual * ventas_productos.cantidad) AS total
FROM ventas_productos
JOIN productos ON productos.id = ventas_productos.id_producto
JOIN ventas ON ventas.id = ventas_productos.id_venta
GROUP BY ventas.id

UPDATE ventas
SET total = total
FROM (
    SELECT ventas.id, sum(productos.precio_actual * ventas_productos.cantidad) AS total
    FROM ventas_productos
    JOIN productos ON productos.id = ventas_productos.id_producto
    JOIN ventas ON ventas.id = ventas_productos.id_venta
    GROUP BY ventas.id
)
WHERE id = id_venta

--Precio de ventas por mes      donde la cantidad de ventas sea menor a 10
SELECT total, fecha, strftime('%m', fecha) AS 'periodo', count(*) AS 'cantidad'
FROM ventas
GROUP BY periodo
HAVING cantidad < 10
ORDER BY periodo
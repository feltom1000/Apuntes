SELECT DISTINCT marca --DISTINCT elimina repetidos;
FROM autos

SELECT NULL IS NULL --Devuelve 1 porque es true;
SELECT NULL IS NOT NULL --Devuelve 0 porque es false;
SELECT 1 IS NULL --Devuelve 0.

SELECT *
FROM choferes
WHERE fecha_egreso IS NOT NULL --Devuelve los que no tienen null en fecha_egreso;

SELECT *, dias_trabajados / 30 AS meses_trabajados
FROM choferes
WHERE fecha_egreso IS NOT NULL --Operaciones con datos;

--LIKE comparador de Strings que acepta dos comodines.
SELECT * 
FROM choferes
WHERE nombre LIKE "H____" --Encuentra lo que empiece con h, y tenga cualquier otra
                            --cosa en los _. En este caso un nombre comenzado con H
                            -- 4 caracteres mas

SELECT * 
FROM choferes
WHERE nombre LIKE "H%" --El % da un numero n de caracteres extras.
                    --Si pones "H___%" busca iniciado con H, y con 3 letras mas o MAS.


SELECT apellido || ',' || nombre AS nombre_completo, mail
FROM choferes --Concatena Strings.


SELECT *
FROM autos
WHERE length(patente) = 6 --Selecciona solo las patentes antiguas con 6 de largo;

SELECT substr(patente, 4) AS numero_patente 
FROM autos
WHERE length(patente) = 6 --Devuelve la parte numerica de la patente
    	                -- substr(columna, numero) corta desde el numero que pones en adelante.

SELECT substr(patente, 0, 4) AS numero_patente 
FROM autos
WHERE length(patente) = 6 --Devuelve la parte de letras


UNION --Combina consultas con las mismas columnas, y descarta duplicados.
    -- UNION ALL no descartaría duplicados.

 
SELECT trim('   federico   ') --Elimina los espacios de ambos lados
                            --esta tmb trimr, o triml , para eliminar el espaciado left o right.

SELECT abs(-1) --Devuelve el numero absoluto (1)

SELECT random() % 100 --genera un numero random de -100 a 100.
SELECT abs(random() % 100) --Numero random positivo hasta 100.


--FECHAS
SELECT datetime(fecha_ingreso / 1000, 'unixepoch')
FROM choferes --Si tenes hora datetime, si no date. Se divide por 1000
            --porque esta expresada en milisegundos, y se le pone el formato
            -- para que sepa interpretarlo.
WHERE datetime(fecha_ingreso / 1000, 'unixepoch') > date('2019-01-01')
                                                --o datetime('2019-01-01 00:00:00')

WHERE datetime(fecha_ingreso / 1000, 'unixepoch') BETWEEN
datetime('2018-01-01 00:00:00') AND datetime('2019-01-01 00:00:00')
--Me devuelve los que ingresaron en 2018.
ORDER BY fecha_ingreso --lo ordeno por el numero.


SELECT datetime(fecha_ingreso / 1000, 'unixepoch')
FROM choferes
WHERE datetime(fecha_ingreso / 1000, 'unixepoch') BETWEEN
    date('now', 'start of month') AND date('now', 'start of month', '+1 month', '-1 day')

SELECT strftime('%d/%m/%y %Hhs', date('now'))
--Formatea la forma en la que sale la fecha/hora com oyo quiera.


SELECT *, coalesce(fecha_egreso, 'no egreso') AS 'fecha_egreso'
FROM choferes --Reeplaza lo que sea null con 'no egreso', lo otro lo deja igual.


--CASE
SELECT *, CASE
    WHERE dias_trabajados < 90 THEN 'junior'
    WHERE dias_trabajados < 365 THEN 'Semisenior'
    ELSE 'senior'
    END AS 'categoria' 
FROM choferes

--COUNT - Devuelve un numero de filas que matchean con la condition
SELECT COUNT(column_name)
FROM table_name
WHERE condition;

--AVG - Devuelve un promedio
SELECT AVG(column_name)
FROM table_name
WHERE condition;

--SUM - suma los valores de una columna numerica.
SELECT SUM(column_name)
FROM table_name
WHERE condition;

--LIMIT - limita la cantidad de resultados
SELECT column_name(s)
FROM table_name
WHERE condition
LIMIT number;
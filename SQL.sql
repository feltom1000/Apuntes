CREATE TABLE "Generos" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
);


CREATE TABLE "Bandas" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"genero_id"	INTEGER NOT NULL,
    FOREIGN KEY("genero_id") REFERENCES "Generos"("id"), --ON DELETE RESTRICT||SET DEFAULT||NO ACTION||CASCADE
	PRIMARY KEY("id" AUTOINCREMENT)
);



    DROP TABLE IF EXISTS "Generos";  --Reinicio la tabla (es decir, la borro y la creo de nuevo).
CREATE TABLE "Generos" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
);

--INSERCION
INSERT INTO "Generos" ("nombre")
VALUES ('Electro'),
('Rock'),
('Jazz'),
('Folklore'),
('Cumbia'),
('Punk');


INSERT INTO "main"."Bandas"
("id", "nombre", "genero_id")
VALUES (1, 'Los Palmeras', 5);

INSERT INTO "main"."Bandas"
("nombre", "genero_id")
VALUES ('Las Pastillas', 3),
    ('Skrillex', 1);


--CONSULTAS
SELECT id, nombre --El conjunto de celdas que quiero
FROM Generos -- De donde las quiero
WHERE (id >= 4 AND id <= 6 AND id != 5) OR id == 1; --Condicion o filtro

SELECT id, nombre 
FROM Generos 
WHERE id+5 > 10;

SELECT * -- TODO
FROM Bandas
WHERE genero_id == 5; --Filtro por genero

SELECT id, UPPER(nombre) SuperNombre --El nombre viene en mayuscula y le pongo un alias llamado "SuperNombre"
FROM Bandas
WHERE genero_id == 5;


--UPDATE
UPDATE "Bandas"
SET nombre = upper(nombre) --modifico todos los nombres a mayusculas.

UPDATE "Bandas"
SET genero_id = 6, nombre = lower(nombre)
WHERE genero_id = 3; --modifico: los generos que son 3, cambian a 6, y el nombre queda en minusculas.

UPDATE "Bandas"
SET genero_id = CASE genero_id --Como un switch-case
                    WHEN 1 THEN 2
                    WHEN 5 THEN 3
                    ELSE genero_id
                END;


                
--DELETE
DELETE FROM "Bandas" --Borra todo el contenido, porque no le puse una condicion.

DELETE FROM "Generos"
WHERE id = 4;
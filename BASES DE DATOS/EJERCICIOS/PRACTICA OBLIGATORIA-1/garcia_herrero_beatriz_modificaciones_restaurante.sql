--Tabla EMPLEADO--
-- Añade un índice que facilite búsquedas frecuentes por Apellidos y Nombre sin duplicados--
CREATE UNIQUE INDEX index_nombre 
ON EMPLEADO(apeEmpleado, nomEmpleado);

-- El Restaurante se ha inaugurado el día 1 de Junio de 2022. Comprueba que la fecha de alta de los empleados no sea anterior a esa fecha --
ALTER TABLE EMPLEADO
ADD CONSTRAINT chk_fechaAlta CHECK(fechaAlta >= '2022-07-01');


--Tabla CAMARERO--
-- El turno de trabajo sólo puede tomar 3 valores: mañana, tarde y noche. Añade esa restricción --
--teniendo encuenta que un camarero puede tener más de un turno (no utilices CHECK) --
--No se me ocurre otra forma--
ALTER TABLE CAMARERO
ADD CONSTRAINT chk_turno CHECK(turno in ('mañana'||'tarde'||'noche');


--Tabla PROVEEDOR--
--Añade las columnas Apellidos y Nombre entre el código y la dirección--
--Para poder colocar esas columnas en ese orden, solo se me ha ocurrido borrar las columnas ya existentes y volver a insertarlas de nuevo en el orden requerido--
ALTER TABLE PROVEEDOR
DROP COLUMN personaContacto;
ALTER TABLE PROVEEDOR
DROP COLUMN faxProveedor; 
ALTER TABLE PROVEEDOR
DROP COLUMN telefProveedor;
ALTER TABLE PROVEEDOR
DROP COLUMN cpProveedor; 
ALTER TABLE PROVEEDOR
DROP COLUMN dirProveedor; 
ALTER TABLE PROVEEDOR
DROP COLUMN nomProveedor;

ALTER TABLE PROVEEDOR
ADD nombre VARCHAR2(15) NOT NULL;
ALTER TABLE PROVEEDOR
ADD apellidos VARCHAR2(20) NOT NULL;
ALTER TABLE PROVEEDOR
ADD nomProveedor VARCHAR2(15) NOT NULL;
ALTER TABLE PROVEEDOR
ADD dirProveedor VARCHAR2(30) NOT NULL;
ALTER TABLE PROVEEDOR
ADD cpProveedor VARCHAR2(5) NOT NULL;
ALTER TABLE PROVEEDOR
ADD telefProveedor VARCHAR2(11) NOT NULL;
ALTER TABLE PROVEEDOR
ADD faxProveedor VARCHAR2(11);
ALTER TABLE PROVEEDOR
ADD personaContacto VARCHAR2(20) NOT NULL;



--Tabla PRODUCTO--
--Añade un índice por Categoría--
CREATE UNIQUE INDEX index_categoria
ON PRODUCTO(categoriaProducto);

--Muestra todos los índices de la tabla--
SELECT * FROM all_indexes WHERE TABLE_NAME = 'PRODUCTO';

--Añade una restricción en la tabla, de forma que el Stock sea entero de 4 cifras, sin signo y que no admita nulos--
ALTER TABLE PRODUCTO 
MODIFY stock number(4); 
--Ya tengo la restricción creada al hacer la table, pero en el caso de no tenerla, se crearía así--
ALTER TABLE PRODUCTO 
ADD CONSTRAINT chk_stock CHECK(stock > 0),

--Borra el índice que acabas de crear--
DROP INDEX index_categoria;


--Tabla PLATO--
--Borra la tabla PROVEEDORES. ¿Qué ocurre?. Borra previamente las claves ajenas--
DROP TABLE PROVEEDOR; 
--No se puede borrar. Primero tenemos que borrar la FK de la tabla PRODUCTO--
ALTER TABLE PRODUCTO 
DROP COLUMN codProveedor;

DROP TABLE PROVEEDOR;


--Base de datos Restaurante Villagarcia de Arriba--
-- Borra la base de datos --
--Borro las tablas en orden--
DROP TABLE solicita;
DROP TABLE cocinados_con;
DROP TABLE contiene;
DROP TABLE PRODUCTO;
DROP TABLE PLATO;
DROP TABLE FACTURA;
DROP TABLE RESERVA;
DROP TABLE MESA;
DROP TABLE COMEDOR;
DROP TABLE ADMINISTRATIVO;
DROP TABLE COCINERO;
DROP TABLE CAMARERO;
DROP TABLE EMPLEADO;
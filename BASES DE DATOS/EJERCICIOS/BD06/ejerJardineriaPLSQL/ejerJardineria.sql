--Ejercicio 2
--programa que cuente los pedidos que hay y muestre en pantalla el número

SET SERVEROUTPUT ON;

DECLARE
	numPedidos NUMBER;
BEGIN
	SELECT COUNT(*) INTO numPedidos
	FROM Pedidos;
	DBMS_OUTPUT.PUT_LINE('El número de pedidos es: '||numPedidos);
END;
/

--Ejercicio 3
--Función numPedidos que devuelva el entero correspondiente al número de pedidos.
CREATE OR REPLACE FUNCTION numPedidos RETURN NUMBER IS
    nPedidos NUMBER;
BEGIN
	SELECT COUNT(*) INTO nPedidos
	FROM Pedidos;
	RETURN(nPedidos);
END numPedidos;
/

--Prueba de la función
DECLARE 
	cuentaPedidos NUMBER;
BEGIN
	cuentaPedidos := numPedidos;
	DBMS_OUTPUT.PUT_LINE('El número de pedidos es: '||cuentaPedidos);
END;
/

--Ejercicio 4
--Procedimiento para obtener los productos cuyo nombre comience por el dato dado.
--Ej. para Nombre LIKE 'Rosal%' pasaríamos la cadena 'Rosal'
--el procedimiento lo mostrará en pantalla

create or replace PROCEDURE producNombre (NomP Productos.Nombre%TYPE) IS
	fila Productos%ROWTYPE;
	CURSOR curProductos IS
		(select P.*
		 from Productos P
		 where P.Nombre LIKE NomP||'%'
		);	
BEGIN
	Open curProductos;	
	DBMS_OUTPUT.PUT_LINE('CODIGO     NOMBRE       GAMA    DIMENSIONES   PROVEEDOR
		STOCK    PRE_VENTA    PRE_PROV'||CHR(10));
	LOOP		
		FETCH curProductos INTO fila;		
		EXIT WHEN curProductos%NOTFOUND;
		--escribo después la línea porque no el atributo NOTFOUND no se hace
		--cierto hasta que no lee la siguiente fila a la última, ya vacía
		DBMS_OUTPUT.PUT_LINE(fila.CodigoProducto||'    '||fila.Nombre||'    '
			||fila.Gama||'  '||fila.Dimensiones||'  '||fila.Proveedor||'  '
			||fila.CantidadEnStock||'  '||fila.PrecioVenta||'  '||fila.PrecioProveedor);
	END LOOP;
	Close curProductos;
END producNombre;
/

--prueba procedimiento
exec producNombre('Rosal');


--Ejemplos iniciales para comprender PL/SQL de Oracle

--Ejemplo 1. Consulta simple almacenada en variable
SET SERVEROUTPUT ON
--Permite usar la función del paquete DBMS_OUTPUT.PUT_LINE para imprimir en pantalla

--Inicio de bloque PL

--Zona de declaración de variables y constantes
DECLARE
	contador number(5):=0;--variable cuenta las filas. Inicializamos a 0

--Zona de proceso
BEGIN
	SELECT COUNT(*) INTO contador FROM FABRICANTE;
	--Consulta: contamos las filas de FABRICANTE. Lo almacenamos en la variable contador

	DBMS_OUTPUT.PUT_LINE('El numero de filas de FABRICANTE es:'|| contador);
	--Imprimimos en pantalla el valor
END;
/
--Fin del bloque

--Ejemplo 2. Alternativa doble IF ELSE
--Consulta simple para contar los productos de un fabricante dado su nombre
--Comprobamos si hay articulos de BQ y los contamos. Sino decimos que no hay

SET SERVEROUTPUT ON

--Inicio del bloque
DECLARE
	contador number(5);	
BEGIN
	contador:=0;
	--Inicializamos la variable en el proceso

	SELECT COUNT(*) INTO contador
	FROM ARTICULO A, FABRICANTE F
	WHERE (A.CodFab=F.CodFab AND NomFab='BQ');
	--Consulta que cuenta el número de artículos de BQ.

	IF (contador>0)	THEN
		DBMS_OUTPUT.PUT_LINE('Hay: ' || contador || ' productos de BQ');
		ELSE
			DBMS_OUTPUT.PUT_LINE('No hay: productos de BQ');
	END IF;
END;
/
--Fin del bloque

--Ejemplo 3. Inserción de un artículo

--Inicio del bloque
BEGIN
	--Sentencia SQL para insertar un artículo
	INSERT INTO ARTICULO
	VALUES ('0000000011','Tablet',350,'0000000015');
END;
/
--Fin del bloque

--Ejemplo 4. Uso de alternativas dobles anidadas (elsif)
-- precios: tipo1 hasta 200€, tipo 2 hasta 400, t3 hasta 1000,t4 más de 1000
--Pedimos por teclado un código de artículo y comprobamos el tramo de precio

DECLARE
	precioArt number(6,2):=0;
	codarti varchar2(10):=&art; --al ser varchar2 al introducir el valor se escribe entre comillas simples, por ejemplo '0000000001' 

	/*la variable art no se declara; sirve para pedir el dato de entrada por teclado*/

BEGIN
	--Consulta para obtener el precio del artículo de código dado
	SELECT Precio INTO precioArt
	FROM ARTICULO A
	WHERE (CodArt=codarti);

	IF (precioArt<=200) THEN
		DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 1.');
		ELSIF (precioArt<=400) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 2.');
			ELSIF (precioArt <=1000) THEN
				DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 3');
				ELSE
					DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 4');
	END IF;
END;
/


-- Ejemplo anterior para un código dado, sin pedir el dato por teclado
DECLARE
	precioArt number(6,2);
BEGIN
	precioArt:=0;
	SELECT A.Precio INTO precioArt
	FROM ARTICULO A
	WHERE (A.CodArt='0000000001');
	IF (precioArt<=200) THEN
		DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 1.');
		ELSIF (precioArt<=400) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 2.');
			ELSIF (precioArt <=1000) THEN
				DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 3');
				ELSE
					DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 4');
	END IF;
END;
/

--Ejemplo anterior usando case
-- precios: tipo1 hasta 200€, tipo 2 hasta 400, t3 hasta 1000,t4 más de 1000

DECLARE
	precioArt number(6,2):=0;
	codarti varchar2(10):=&art;
BEGIN
	SELECT Precio INTO precioArt
	FROM ARTICULO A
	WHERE (CodArt=codarti);
	case
		WHEN (precioArt<=200) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 1.');
		WHEN (precioArt<=400) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 2.');
		WHEN (precioArt <=1000) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 3');
		ELSE
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 4');
	END case;
END;
/

--Ejemplo 5. Uso de bucle con condicion al final
DECLARE
	contador number(6);
	num number(6);
BEGIN
	contador:=1;
	num:=&numero;
	--Pedimos un valor por teclado
	LOOP				
		DBMS_OUTPUT.PUT_LINE('Contando: '|| contador);
		contador:=contador+1;
		EXIT WHEN (contador>num); --salimos si pasamos del valor num
	END LOOP;
END;
/

--Ejemplo 6. Uso del bucle con condicion al principio
DECLARE
	contador number(6);
	num number(6);
BEGIN
	contador:=1;
	num:=&numero;
	--pedimos un valor por teclado
	WHILE (contador<=num) LOOP
		DBMS_OUTPUT.PUT_LINE('Contando: '|| contador);
		contador:=contador+1;
	END LOOP;
END;
/

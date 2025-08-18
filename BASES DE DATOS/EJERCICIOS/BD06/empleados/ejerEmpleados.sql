--examen práctico 1 evaluación 3

SET SERVEROUTPUT ON

--ejercicio 1
--programa que cuente los productos que hay
DECLARE
	nproductos NUMBER;
BEGIN
	SELECT COUNT(*) INTO nproductos
	FROM Productos;
	DBMS_OUTPUT.PUT_LINE('Hay '||nproductos||' productos.');
END;
/

--ejercicio 2
--función que devuelva el límite de crédito del cliente pasado por parámetro

CREATE OR REPLACE FUNCTION creditCliente (codCliente Clientes.CodigoCliente%TYPE) 
RETURN NUMBER IS
	credit NUMBER;

BEGIN
	SELECT LimiteCredito INTO credit
	FROM Clientes
	WHERE (CodigoCliente=codCliente);
	RETURN(credit);
END creditCliente;
/

--programa para probar la función
DECLARE
	limCredit NUMBER;	
BEGIN
	limCredit:=creditCliente(&clien);
	DBMS_OUTPUT.PUT_LINE('El limite de crédito del cliente es: '||limCredit);
END;
/

--ejercicio 3. Procedimiento para obtener los clientes VIP (aquellos que
--tienen un límite de crédito igual o superior al dado por parámetro).
CREATE OR REPLACE PROCEDURE clientesVIP (credit Clientes.LimiteCredito%TYPE) IS
	--Zona de variables
	fila Clientes%ROWTYPE;
	CURSOR curClientes IS
		(select C.*
		 from Clientes C
		 where C.LimiteCredito >= credit
		);
	noDatos EXCEPTION;
	creditNeg EXCEPTION;
BEGIN
	IF (credit<0) THEN
		RAISE creditNeg;
	END IF;
	Open curClientes;	
	DBMS_OUTPUT.PUT_LINE('COD_CLIENTE          NOM_CLIENTE          CONTACTO          LIMITE_CREDITO'||CHR(10));
	LOOP		
		FETCH curClientes INTO fila;		
		EXIT WHEN curClientes%NOTFOUND;
		--escribo después la línea porque sino el atributo NOTFOUND no se hace
		--cierto hasta que no lee la siguiente fila a la última, ya vacía
		DBMS_OUTPUT.PUT_LINE(fila.CodigoCliente||'                     '||fila.NombreCliente
		||'       '||fila.NombreContacto||'       '||fila.LimiteCredito);
	END LOOP;
	IF (curClientes%ROWCOUNT=0) THEN
		RAISE noDatos;
	END IF;
	Close curClientes;

	--Gestión de errores
	EXCEPTION
		WHEN noDatos THEN
			DBMS_OUTPUT.PUT_LINE('No hay clientes vip.');
		WHEN creditNeg THEN
			DBMS_OUTPUT.PUT_LINE('El límite de crédito no puede ser negativo');
		WHEN OTHERS THEN
			DBMS_OUTPUT.PUT_LINE('CODIGO DE ERROR: '||SQLCODE);

END clientesVIP;
/
15. crea una funcion a la que le pasaremos como parametros de entrada: MATRICULA, NUEVO_PRECIO_COMPRA. lA FUNCION MODIFICARA LOS DATOS DEL COCHE QUE TENGA LA MATRICULA INTRODUCIDA ACTUALIZANDO EL PRECIO_COMPRA DE LA SIGUIENTE FORMA:

-Si precio_compra es nulo--> hacer un update en el campo precio_compra asignandole el valor de nuevo_precio_compra

-Si no--> hacer un update en el campo precio_compra asignandole el valor de precio_compra+(precio_compra-nuevo_precio_compra)

la funcion devolvera el numero de filas actualizadas
crea un bloque anonimo que ejecute la funcion anterior y muestre el resultado devuelto por la funcion

CREATE OR REPLACE FUNCTION actualizaPrecioCoche (v_matricula coche.matricula%type, v_nuevo_precio_compra coche.precio_compra%type)
RETURN NUMBER
IS 
    v_precio_compra coche.precio_compra%type;
BEGIN
    SELECT precio_compra INTO v_precio_compra
    FROM coche WHERE matricula = v_matricula;
    
    IF v_precio_compra IS NULL THEN
        UPDATE coche
        SET precio_compra = v_nuevo_precio_compra
        WHERE matricula = v_matricula;
    ELSE
        UPDATE coche
        SET precio_compra = precio_compra + (precio_compra - v_nuevo_precio_compra)
        WHERE matricula = v_matricula;
    END IF;
    
    RETURN SQL%ROWCOUNT;

END actualizaPrecioCoche;
/
DECLARE
    v_matricula coche.matricula%type := &matricula;
    v_nuevo_precio_compra coche.precio_compra%type := &nuevo_precio;
    v_total_filas NUMBER(8);
BEGIN
    v_total_filas := actualizaPrecioCoche (v_matricula, v_nuevo_precio_compra);
    DBMS_OUTPUT.PUT_LINE('Se han modificado ' || v_total_filas || ' filas');
END;
/

16. Crea procedimiento que reciba como parametros de entrada:P_ID_MARCA,P_NUMERO_COCHES. Utiliza un bucle para insertar N registros nuevos en la tabla COCHE. El numero de registros a insertar viene indicado por el parametro P_NUMEROS_COCHES(CONTADOR) y el bucle empezará en 1, los datos a insertar seran:

-matricula='A00'||CONTADOR
-DESCRIPCION=p_id_marca
-id_marca=p_id_marca
-precio_compra=nulo

Controlar excepcion para cuando exista algun coche en la bbdd y se viole la pk

CREATE OR REPLACE PROCEDURE creaCoches (p_id_marca coche.id_marca%type, p_numero_coches number)

IS

BEGIN
    FOR contador IN 1..p_numero_coches LOOP
        INSERT INTO coche VALUES('A00'||contador, p_id_marca, p_id_marca, null);
    END LOOP;
    
EXCEPTION
    WHEN dup_val_on_index THEN 
    DBMS_OUTPUT.PUT_LINE('Registro duplicado');
    
END;
/
DECLARE
    p_id_marca coche.id_marca%type := &id;
    p_numero_coches number(8) := &num;
BEGIN

    creaCoches(p_id_marca, p_numero_coches);
END;
/

18.Crea un procedimiento al que le pasaremos el dni_cliente y la matricula. El procedimiento debera controlar en las ventas de los coches(tabla vende) los siguientes supuestos:
    A.SI NO EXISTE UN REGISTRO CON ESE DNI_CLIENTE Y ESA MATRICULA SALTARA A LA ZONA DE EXCEPCIONES Y MOSTRARA UN MENSAJE
    "NO EXISTE LA VENTA INTRODUCIDA"
    B.SI EXISTE LA VENTA INTRODUCIDA:
        I.MOSTRARA EL PRECIO ANTIGUO ||
        II.ACTUALIZARA EL PRECIO SUBIENDO 1000 EUROS
        III. DEVOLVERA EN UN PARAMETRO DE SALIDA DEL PROCEDIMIENTO(PS_NUEVO_PRECIO) EL PRECIO NUEVO TRAS LA ACTUALIZACION
CREA UN BLOQUE ANONIMO QUE LLAME AL PROCEDIMIENTO ANTERIOR Y MUESTRE EL PRECIO NUEVO DEVUELTO POR EL PROCEDIMIENTO.

CREATE OR REPLACE PROCEDURE actualizaVenta(
    p_dni_cliente vende.dni_cliente%type, 
    p_matricula vende.matricula%type, 
    ps_nuevo_precio OUT vende.matricula%type)
AS
    venta vende%rowtype;
BEGIN
    SELECT * INTO venta
    FROM vende
    WHERE dni_cliente = p_dni_cliente
    AND matricula = p_matricula;
    
    DBMS_OUTPUT.PUT_LINE('El precio antiguo es: ' || venta.precio);
    
    ps_nuevo_precio := venta.precio + 1000;
    
    UPDATE vende 
    SET precio = ps_nuevo_precio
    WHERE dni_cliente = p_dni_cliente
    AND matricula = p_matricula;
    
EXCEPTION
    WHEN no_data_found THEN
    DBMS_OUTPUT.PUT_LINE('No existe la venta introducida');
    
END;
/
DECLARE
    v_dni_cliente vende.dni_cliente%type := &dni; 
    v_matricula vende.matricula%type := &matricula;
    v_nuevo_precio vende.matricula%type;
BEGIN
    actualizaVenta(v_dni_cliente, v_matricula, v_nuevo_precio);
    IF v_nuevo_precio IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('El nuevo precio es: ' || v_nuevo_precio);
    END IF;
END;
/
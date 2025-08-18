create or replace PROCEDURE pg_cliente(p_codigocliente IN NUMBER)
IS
  v_nombre_cliente clientes.nombrecliente%TYPE;
  v_ciudad_cliente clientes.ciudad%TYPE;
  v_pais_cliente clientes.pais%TYPE;
  v_total_pagos pagos.cantidad%TYPE := 0;
  v_cantidad pagos.cantidad%TYPE;
BEGIN
  -- Obtener datos del cliente
  SELECT nombrecliente, ciudad, pais
  INTO v_nombre_cliente, v_ciudad_cliente, v_pais_cliente
  FROM clientes
  WHERE codigocliente = p_codigocliente;

  -- Obtener el total de pagos del cliente
  SELECT SUM(cantidad)
  INTO v_total_pagos
  FROM pagos
  WHERE codigocliente = p_codigocliente;

  -- Mostrar información del cliente
  DBMS_OUTPUT.PUT_LINE('CODIGO CLIENTE: ' || p_codigocliente);
  DBMS_OUTPUT.PUT_LINE('NOMBRE CLIENTE: ' || v_nombre_cliente);
  DBMS_OUTPUT.PUT_LINE('CIUDAD CLIENTE: ' || v_ciudad_cliente);
  DBMS_OUTPUT.PUT_LINE('PAIS CLIENTE: ' || v_pais_cliente);
  DBMS_OUTPUT.PUT_LINE('==========================================================');
  DBMS_OUTPUT.PUT_LINE('ID-TRANSACCION      FECHA          FORMA       CANTIDAD');
  DBMS_OUTPUT.PUT_LINE('==========================================================');

  -- Obtener pagos del cliente y mostrar información
  FOR pagos IN (SELECT idtransaccion, fechapago, formapago, cantidad
               FROM pagos
               WHERE codigocliente = p_codigocliente
               ORDER BY fechapago)
  LOOP
    DBMS_OUTPUT.PUT_LINE(pagos.idtransaccion || '       ' || pagos.fechapago || '       ' || pagos.formapago || '      ' || pagos.cantidad);
  END LOOP;

  DBMS_OUTPUT.PUT_LINE('=======================================================================');
  DBMS_OUTPUT.PUT_LINE('TOTAL PAGOS EFECTUADOS: ' || v_total_pagos);

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('El cliente con código ' || p_codigocliente || ' no existe.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Ha ocurrido un error: ' || SQLERRM);
END;

-- para ejecutarle :
-- SET SERVEROUTPUT ON;
-- EXEC pagos_cliente(1);
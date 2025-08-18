7. Mostrar el nombre de un cliente dado su codigo.

DECLARE
    v_codigoCliente clientes.codigoCliente%type :=&codigo;
    v_nombreCliente clientes.nombreCliente%type;
BEGIN
    SELECT nombreCliente INTO v_nombreCliente
    FROM clientes
    WHERE codigoCliente = v_codigoCliente;
    
    DBMS_OUTPUT.PUT_LINE('El nombre del cliente es: '|| v_nombreCliente);
END;
/

8. Mostrar el precioVenta y la gama de un producto dado su codigo.

DECLARE
    v_codigoProducto productos.codigoProducto%type :=&codigo;
    v_precioVenta productos.precioVenta%type;
    v_gama productos.gama%type;
BEGIN
    SELECT gama, precioVenta INTO v_gama, v_precioVenta
    FROM productos
    WHERE codigoProducto = v_codigoProducto;
    
    DBMS_OUTPUT.PUT_LINE('La gama es: '|| v_gama);
    DBMS_OUTPUT.PUT_LINE('El precio venta es: '|| v_precioVenta);
END;
/

9. Mostrar toda la informacion de un pedido dado su codigo (fechaEsperada, fechaEntrega, fechapedido, estado, comentarios)

DECLARE
    v_codigoPedido pedidos.codigoPedido%type :=&codigo;
    v_pedido pedidos%rowtype;
BEGIN
    SELECT * INTO v_pedido
    FROM pedidos
    WHERE codigoPedido = v_codigoPedido;
    
    DBMS_OUTPUT.PUT_LINE('La fecha pedido es: '|| v_pedido.fechaPedido);
    DBMS_OUTPUT.PUT_LINE('La fecha esperada es: '|| v_pedido.fechaEsperada);
    DBMS_OUTPUT.PUT_LINE('La fecha entrega es: '|| v_pedido.fechaEntrega);
    DBMS_OUTPUT.PUT_LINE('El estado es: '|| v_pedido.estado);
END;
/

10. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el codigo por parametro.

CREATE OR REPLACE FUNCTION pagosCliente(codcliente clientes.codigocliente%type)
RETURN NUMBER
IS 
    sumaPagos pagos.cantidad%type := 0;
BEGIN
    SELECT SUM(cantidad) INTO sumaPagos
    FROM pagos
    WHERE codcliente = codigocliente;
    
    RETURN sumaPagos;
    
END pagosCliente;
/
DECLARE
    codCliente pedidos.codigocliente%type := &codigo;
    sumaPagos pagos.cantidad%type;
BEGIN
    sumaPagos := PagosCliente(codCliente);
    DBMS_OUTPUT.PUT_LINE('La suma de pagos es ' || sumaPagos);
END;
/





11. Realizar un método o procedimiento que muestre el total en euros de un pedido, pasale el codigo por parametro.

CREATE OR REPLACE PROCEDURE totalPedido(codpedido pedidos.codigopedido%type)
IS sumaTotal NUMBER(8) := 0;
BEGIN
    SELECT SUM(dp.cantidad * dp.preciounidad) INTO sumaTotal
    FROM pedidos p, detallepedidos dp
    WHERE p.codigopedido = dp.codigopedido AND p.codigopedido = codpedido;
    
    DBMS_OUTPUT.PUT_LINE('El pedido total es ' || sumaTotal);
END totalPedido;
/

declare
  codpedido pedidos.codigopedido%type := &codigo;
begin
  totalPedido(codpedido);
  
end;
/




12. Mostrar el nombre de un cliente dado su codigo. Controla en caso de que no se encuentre, mostrando un mensaje por ejemplo.

DECLARE
    codcliente clientes.codigocliente%type := &cliente;
    nombre clientes.nombrecliente%type;
BEGIN
    SELECT nombrecliente INTO nombre
    FROM clientes
    WHERE codcliente = codigocliente;
    DBMS_OUTPUT.PUT_LINE('El nombre es ' || nombre);
EXCEPTION
    WHEN no_data_found then
    DBMS_OUTPUT.PUT_LINE('El cliente no existe');
END;
/


13. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el codigo por parametro.  Controla en caso de que no se encuentre, en ese caso devuelve un -1.

CREATE OR REPLACE FUNCTION pagosCliente(codcliente clientes.codigocliente%type)
RETURN NUMBER
IS 
    sumaPagos pagos.cantidad%type := 0;
BEGIN
    SELECT SUM(cantidad) INTO sumaPagos
    FROM pagos
    WHERE codcliente = codigocliente;

    IF sumaPagos IS NULL THEN
        RAISE no_data_found;
    ELSE
        RETURN sumaPagos;
    END IF;
    
    RETURN sumaPagos;
EXCEPTION
    WHEN no_data_found THEN
    RETURN -1;

END pagosCliente;
/
DECLARE
    codCliente pedidos.codigocliente%type := &codigo;
    sumaPagos pagos.cantidad%type;
BEGIN
    sumaPagos := PagosCliente(codCliente);
    IF sumaPagos = -1 THEN
        DBMS_OUTPUT.PUT_LINE('El cliente no existe');
    ELSE
        DBMS_OUTPUT.PUT_LINE('La suma de pagos es ' || sumaPagos);
    END IF;
END;
/



14. Realizar un método o procedimiento que muestre el total en euros de un pedido, pasale el codigo por parametro. 
Controla en caso de que no se encuentre, en ese caso devuelve un 0. 
Pasale otro parametro, si supera ese limite, lanzaremos una excepcion propia y devolveremos un 0.


CREATE OR REPLACE FUNCTION totalPedido_f(codpedido pedidos.codigopedido%type, limite NUMBER)
RETURN NUMBER
IS 
    sumaTotal NUMBER(8) := 0;
    limite_superado EXCEPTION;
BEGIN
    SELECT SUM(dp.cantidad * dp.preciounidad) INTO sumaTotal
    FROM pedidos p, detallepedidos dp
    WHERE p.codigopedido = dp.codigopedido AND p.codigopedido = codpedido;
    
    IF sumaTotal IS NULL THEN
        RAISE no_data_found;
    ELSE  
        IF sumaTotal > limite THEN
            RAISE limite_superado;
        ELSE
            RETURN sumaTotal;
        END IF;   
    END IF;
    
EXCEPTION

    WHEN no_data_found THEN 
        DBMS_OUTPUT.PUT_LINE('No existe el pedido');
        RETURN 0;
    WHEN limite_superado THEN
        DBMS_OUTPUT.PUT_LINE('Limite superado');
        RETURN 0;
END totalPedido_f;
/

declare
  codpedido pedidos.codigopedido%type := &codigo;
  limite NUMBER(8) := &limite;
  sumaTotal NUMBER(8);
begin
  sumaTotal := totalPedido_f(codpedido, limite);
  DBMS_OUTPUT.PUT_LINE('El pedido total es ' || sumaTotal);
end;
/
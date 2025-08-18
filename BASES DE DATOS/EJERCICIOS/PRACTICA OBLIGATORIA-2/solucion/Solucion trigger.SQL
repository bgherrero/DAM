
El evento que da lugar a la ejecución del trigger es el borrado de un cliente
El evento se lanza despues de borrar al cliente
y por cada  fila que se borre buscamos los pedidos junto con el detalle de los mismos para calcular
el importe de facturacion
NO hay que acceder a la tabla clientes para nada

Seria algo así:

CREATE OR REPLACE TRIGGER Borrado_clientes 
       AFTER DELETE on CLIENTES FOR EACH ROW
 
  DECLARE Tot_F NUMBER(16,2);

BEGIN
   
    Select sum(cantidad*preciounidad)
    into Tot_F
    From detallepedidos natural join pedidos
    where codigocliente=:old.codigocliente;
    
    -- Inserto en la tabla que he creado
    INSERT INTO Clientes_Borrados 
    VALUES(:old.nombrecliente,SYSDATE,Tot_F);

END;

Es verdad que va a dar error por el tema de las restricciones de integridad.
SE puede probar con un update, en lugar de borrado y así compruebas que funciona.
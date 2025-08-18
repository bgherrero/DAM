--TABLA FAMILIA. Contine las familias a las que perteneces los productos.
CREATE TABLE FAMILIA(
	Codfamilia NUMBER(3,0) PRIMARY KEY,
	Denofamilia VARCHAR2(50) NOT NULL UNIQUE
);

--TABLA PRODUCTO. Contine información general sobre los productos que distribuye la empresa a las tiendas.
CREATE TABLE PRODUCTO(
	Codproducto NUMBER(5,0) PRIMARY KEY,
	Denoproducto VARCHAR2(20) NOT NULL,
	Descripcion VARCHAR2(100),
	PrecioBase NUMBER (6,2) NOT NULL, 
	PorcReposicion NUMBER(3,0),
	UnidadesMinimas NUMBER(4,0) NOT NULL,
	CodFamilia NUMBER(3,0) NOT NULL CONSTRAINT pro_cod_FK REFERENCES FAMILIA,
	CONSTRAINT pro_ck CHECK(PrecioBase > 0 AND PorcReposicion > 0 AND UnidadesMinimas > 0)
);

--TABLA TIENDA. Contine información básica sobre las tiendas que distribuyen los productos
CREATE TABLE TIENDA(
	Codtienda NUMBER(3,0) PRIMARY KEY,
	Denotienda VARCHAR2(20) NOT NULL,
	Telefono VARCHAR2(11),
	CodigoPostal VARCHAR2(5) NOT NULL,
	Provincia VARCHAR2(5) NOT NULL
);

--TABLA STOCK. Contiene, para cada tienda, el número disponible de cada producto.
CREATE TABLE STOCK(
	Codtienda NUMBER(3,0) CONSTRAINT sto_tie_fk REFERENCES TIENDA,
	Codproducto NUMBER(5,0) CONSTRAINT sto_pro_fk REFERENCES PRODUCTO,
	Unidades NUMBER(6,0) NOT NULL CONSTRAINT sto_uni_ck CHECK(Unidades > 0),
	PRIMARY KEY (Codtienda, Codproducto)
);
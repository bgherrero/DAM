CREATE TABLE EMPLEADO(
dniEmpleado VARCHAR(9) NOT NULL,
nomEmpleado VARCHAR(15) NOT NULL,
apeEmpleado VARCHAR(20) NOT NULL,
dirEmpleado VARCHAR(30) NOT NULL,
ciudadEmpleado VARCHAR(15) NOT NULL,
cpEmpleado VARCHAR(5) NOT NULL,
telefEmpleado VARCHAR(11) NOT NULL,
fechaAlta DATE NOT NULL,
categoria VARCHAR(10),
salario NUMBER(6,2),
CONSTRAINT pk_dniEmpleado PRIMARY KEY(dniEmpleado),
CONSTRAINT chk_salario CHECK(salario > 0));

CREATE TABLE CAMARERO(
dniCamarero VARCHAR2(9) NOT NULL,
turno VARCHAR2(6) NOT NULL,
añosExperiencia NUMBER(2),
dniEncargado VARCHAR2(9) NOT NULL,
CONSTRAINT pk_dniCamarero PRIMARY KEY(dniCamarero),
CONSTRAINT fk_dniCamarero FOREIGN KEY(dniCamarero) REFERENCES EMPLEADO(dniEmpleado),
CONSTRAINT fk_dniEncargado FOREIGN KEY(dniEncargado) REFERENCES CAMARERO(dniCamarero),
CONSTRAINT chk_turno CHECK(turno in ('mañana'||'tarde'||'noche')),
CONSTRAINT chk_añosExperiencia CHECK(añosExperiencia >= 0));

CREATE TABLE COCINERO(
dniCocinero VARCHAR2(9) NOT NULL,
puesto VARCHAR2(10),
especialidad VARCHAR2(10),
CONSTRAINT pk_dniCocinero PRIMARY KEY(dniCocinero),
CONSTRAINT fk_dniCocinero FOREIGN KEY (dniCocinero) REFERENCES EMPLEADO(dniEmpleado));

CREATE TABLE ADMINISTRATIVO(
dniAdministrativo VARCHAR2(9) NOT NULL,
cargo VARCHAR2(10),
CONSTRAINT pk_dniAdministrativo PRIMARY KEY(dniAdministrativo),
CONSTRAINT fk_dniAdministrativo FOREIGN KEY (dniAdministrativo) REFERENCES EMPLEADO(dniEmpleado));

CREATE TABLE COMEDOR(
codComedor VARCHAR2(5) NOT NULL,
nomComedor VARCHAR2(15) NOT NULL,
capMax NUMBER(4) NOT NULL,
numMesas NUMBER (2) NOT NULL,
localizacion VARCHAR2(15) NOT NULL,
CONSTRAINT pk_codComedor PRIMARY KEY(codComedor),
CONSTRAINT chk_capMax CHECK(capMax > 0),
CONSTRAINT chk_numMesas CHECK(numMesas > 0));

CREATE TABLE MESA(
codMesa VARCHAR2(5) NOT NULL,
codComedor VARCHAR2(5) NOT NULL,
asientos NUMBER(2) NOT NULL,
dniEmpleado VARCHAR2(9) NOT NULL,
CONSTRAINT pk_codMesa_codComedor PRIMARY KEY(codMesa, codComedor),
CONSTRAINT fk_codComedor_Mesa FOREIGN KEY(codComedor) REFERENCES COMEDOR(codComedor),
CONSTRAINT fk_dniCamarero_Mesa FOREIGN KEY(dniEmpleado) REFERENCES CAMARERO(dniCamarero));


CREATE TABLE RESERVA(
numReserva VARCHAR2(5) NOT NULL,
fechaReserva DATE,
nomReserva VARCHAR2(15) NOT NULL,
fechaComida DATE NOT NULL,
turnoComida VARCHAR2(5) NOT NULL,
numPersonas NUMBER(3) NOT NULL,
otros VARCHAR2(50),
codMesa VARCHAR2(5) NOT NULL,
codComedor VARCHAR2(5) NOT NULL,
CONSTRAINT pk_numReserva PRIMARY KEY(numReserva),
CONSTRAINT fk_mesaComedor_Reserva FOREIGN KEY(codMesa, codComedor) REFERENCES MESA(codMesa, codComedor),
CONSTRAINT chk_numPersonas CHECK(numPersonas > 0));


CREATE TABLE FACTURA(
numFactura VARCHAR2(5) NOT NULL,
fechaFactura DATE,
numReserva VARCHAR2(5) NOT NULL,
CONSTRAINT pk_numFactura PRIMARY KEY(numFactura),
CONSTRAINT fk_numReresva_Factura FOREIGN KEY(numReserva) REFERENCES RESERVA(numReserva));

CREATE TABLE PLATO(
codPlato VARCHAR2(5) NOT NULL,
nomPlato VARCHAR2(15) NOT NULL,
tipoPlato VARCHAR2(15),
despripcionPlato VARCHAR2(50),
precioPlato NUMBER(3,2) NOT NULL,
CONSTRAINT pk_codPlato PRIMARY KEY(codPlato),
CONSTRAINT chk_precioPlato CHECK(precioPlato > 0));


CREATE TABLE PROVEEDOR(
codProveedor VARCHAR2(5) NOT NULL,
nomProveedor VARCHAR2(15) NOT NULL,
dirProveedor VARCHAR2(30) NOT NULL,
cpProveedor VARCHAR2(5) NOT NULL,
telefProveedor VARCHAR2(11) NOT NULL,
faxProveedor VARCHAR2(11),
personaContacto VARCHAR2(20) NOT NULL,
CONSTRAINT pk_codProveedor PRIMARY KEY(codProveedor));


CREATE TABLE PRODUCTO(
codProducto VARCHAR2(5) NOT NULL,
descripcionProducto VARCHAR2(50),
stock NUMBER(5,3) NOT NULL,
unidadBase VARCHAR2(10) NOT NULL,
categoriaProducto VARCHAR2(10),
codProveedor VARCHAR2(5) NOT NULL,
CONSTRAINT pk_codProducto PRIMARY KEY(codProducto),
CONSTRAINT fk_codProveedor_Producto FOREIGN KEY(codProveedor) REFERENCES PROVEEDOR(codProveedor),
CONSTRAINT chk_stock CHECK(stock > 0));

CREATE TABLE contiene(
codPlato VARCHAR2(5) NOT NULL,
numFactura VARCHAR2(5) NOT NULL,
unidadPlato VARCHAR2(5) NOT NULL,
CONSTRAINT pk_codPlato_numFactura PRIMARY KEY(codPlato, numFactura),
CONSTRAINT fk_codPlato_contiene FOREIGN KEY(codPlato) REFERENCES PLATO(codPlato),
CONSTRAINT fk_numFactura_contiene FOREIGN KEY(numFactura) REFERENCES FACTURA(numFactura),
CONSTRAINT chk_unidadPlato CHECK(unidadPlato > 0));


CREATE TABLE cocinados_con(
codPlato VARCHAR2(5) NOT NULL,
codProducto VARCHAR2(5) NOT NULL,
CONSTRAINT pk_codPlato_codProducto PRIMARY KEY(codPlato, codProducto),
CONSTRAINT fk_codPlato_cocinado FOREIGN KEY(codPlato) REFERENCES PLATO(codPlato),
CONSTRAINT fk_codProducto_cocinado FOREIGN KEY(codProducto) REFERENCES PRODUCTO(codProducto));


CREATE TABLE solicita(
numReserva VARCHAR2(5) NOT NULL,
codMesa VARCHAR2(5) NOT NULL,
codComedor VARCHAR2(5) NOT NULL,
CONSTRAINT pk_reserva_mesa_comedor PRIMARY KEY(numReserva, codMesa, codComedor),
CONSTRAINT fk_numReresva FOREIGN KEY(numReserva) REFERENCES RESERVA(numReserva),
CONSTRAINT fk_mesaComedor_solicita FOREIGN KEY(codMesa, codComedor) REFERENCES MESA(codMesa, codComedor));

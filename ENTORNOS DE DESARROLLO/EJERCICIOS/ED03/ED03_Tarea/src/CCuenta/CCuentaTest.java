package CCuenta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CCuentaTest {
	
	CCuenta miCuenta = new CCuenta();
	
	int ingreso1 = -5;
	int ingreso2 = 5;
	int ingreso3 = -3;
	
	@Test
	void testIngresar1() {
		assertEquals(1, miCuenta.ingresar(ingreso1));				
	}
	@Test
	void testIngresar2() {
		assertEquals(0, miCuenta.ingresar(ingreso2));				
	}
	@Test
	void testIngresar3() {
		assertEquals(2, miCuenta.ingresar(ingreso3));				
	}
}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ort.aed2.ob20152.ISistema;
import ort.aed2.ob20152.Retorno;
import ort.aed2.ob20152.Sistema;

public class TestMapa {
	ISistema sistema;

	@Before
	public void prepararTest() {
		sistema = new Sistema();
	}

	@Test
	public void testInicializarSistema() {
		Retorno ret = sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, ret.resultado);
	}

	@Test
	public void testDestruirSistema() {
		Retorno ret = sistema.destruirSistema();
		assertEquals(Retorno.Resultado.OK, ret.resultado);
	}

}

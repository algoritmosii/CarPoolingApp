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
	public void contexto() {
		sistema = new Sistema();

	}

	@Test
	public void testA_InicializarSistema() {
		System.out.println(" test: inicializarSistema");
		ISistema sistema;
		sistema = new Sistema();
		Retorno ret = sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, ret.resultado);
		@SuppressWarnings("unused")
		Retorno ret2 = sistema.destruirSistema();
		// TODO log resultados de test con fecha
	}

	@Test
	public void testB_RegistrarEsquina() {
		System.out.println(" test: registrarEsquina");
		ISistema sistema;
		sistema = new Sistema();
		Retorno ret = sistema.inicializarSistema(10);
		if (ret.resultado.equals(Retorno.Resultado.OK)) {
			Retorno ret2 = sistema.registrarEsquina(12.2, 22.2);
			assertEquals(Retorno.Resultado.OK, ret2.resultado);
		}
	}
	
	@Test
	public void testC_DestruirSistema() {
		System.out.println(" test: destruirSistema");
		ISistema sistema;
		sistema = new Sistema();
		Retorno ret = sistema.inicializarSistema(10);
		if (ret.resultado.equals(Retorno.Resultado.OK)) {
			Retorno ret2 = sistema.destruirSistema();
			assertEquals(Retorno.Resultado.OK, ret2.resultado);
		}
	}
}

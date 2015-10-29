package ort.aed2.ob20152;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsSistema {

	@Test
	public void testRegistroMovil() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		//Datos de la prueba
		String conductor = "3.702.156-9";
		String matricula = "ADB 1234";
		//Estimulo
		Retorno ret = sistema.registrarMovil(matricula, conductor);
		assertEquals(Retorno.Resultado.OK, ret.resultado);	//Deberia retornar OK
		
	}


}

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ort.aed2.ob20152.ISistema;
import ort.aed2.ob20152.Retorno;
import ort.aed2.ob20152.Sistema;
import ort.aed2.ob20152.Retorno.Resultado;

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

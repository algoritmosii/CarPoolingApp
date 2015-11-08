package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ort.aed2.ob20152.ISistema;
import ort.aed2.ob20152.Retorno;
import ort.aed2.ob20152.Sistema;

public class TestsSistema {

	ISistema sistema = new Sistema();
	
	@Test
	public void testRegistroMovil() {
		
		sistema.inicializarSistema(10);
		
		//Datos de la prueba
		String conductor = "3.702.156-9";
		String matricula = "ZDB 1234";
		
		String conductor2 = "4.702.156-9";
		String matricula2 = "BDC 1234";
		
		String conductor3 = "5.702.156-9";
		String matricula3 = "CDC 1234";
		
		String conductor4 = "7.702.156-9";
		String matricula4 = "FDC 1234";
		
		String conductor5 = "9.702.156-9";
		String matricula5 = "ZDC 1234";
		
		//Estimulo
		Retorno ret = sistema.registrarMovil(matricula, conductor);
		assertEquals(Retorno.Resultado.OK, ret.resultado);	//Deberia retornar OK

		Retorno ret2 = sistema.registrarMovil(matricula2, conductor2);
		assertEquals(Retorno.Resultado.OK, ret2.resultado);	//Deberia retornar OK
		
		Retorno ret3 = sistema.registrarMovil(matricula3, conductor3);
		assertEquals(Retorno.Resultado.OK, ret3.resultado);	//Deberia retornar OK
		
		Retorno ret4 = sistema.registrarMovil(matricula4, conductor4);
		assertEquals(Retorno.Resultado.OK, ret4.resultado);	//Deberia retornar OK
		
		Retorno ret5 = sistema.registrarMovil(matricula5, conductor5);
		assertEquals(Retorno.Resultado.OK, ret5.resultado);	//Deberia retornar OK
		
		//deshabilitar movil 
		Retorno ret6 = sistema.deshabilitarMovil(matricula4);
		assertEquals(Retorno.Resultado.OK, ret6.resultado);
		
		
		//eliminar movil 
		Retorno ret7 = sistema.eliminarMovil(matricula2);
		assertEquals(Retorno.Resultado.OK, ret7.resultado);

		// informe moviles
		Retorno ret8 = sistema.informeMoviles();
		assertEquals(Retorno.Resultado.OK, ret8.resultado);	
		
	}
	
	/*@Test
	public void testDeshabilitarMovil() {
		
		//Datos de la prueba
		String matricula = "ADB 1234";
		
		Retorno ret = sistema.deshabilitarMovil(matricula);
		assertEquals(Retorno.Resultado.OK, ret.resultado);	//Deberia retornar OK
	}*/
}

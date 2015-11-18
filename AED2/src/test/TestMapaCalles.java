package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ort.aed2.ob20152.ISistema;
import ort.aed2.ob20152.Retorno;
import ort.aed2.ob20152.Sistema;

public class TestMapaCalles {

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
	}

	@Test
	public void testB_RegistrarEsquina() {

		System.out.println(" test: registrarEsquina");
		ISistema sistema;
		sistema = new Sistema();
		Retorno ret = sistema.inicializarSistema(10);
		if (ret.resultado.equals(Retorno.Resultado.OK)) {
			Double uniORTX = -34.9050291;
			Double uniORTY = -56.1915827;
			Retorno ret2 = sistema.registrarEsquina(uniORTX, uniORTY);
			assertEquals(Retorno.Resultado.OK, ret2.resultado);
		}
	}

	@Test
	public void testB_RegistrarEsquinasVarias() {

		System.out.println(" test: registrarEsquinasVarias");
		ISistema sistema;
		sistema = new Sistema();
		
		Retorno ret = sistema.inicializarSistema(6);
		if (ret.resultado.equals(Retorno.Resultado.OK)) {

			System.out.println("Fac de quimica");
			Double facQuimicaX = -34.8883007;
			Double facQuimicaY = -56.1850452;
			Retorno ret9 = sistema.registrarEsquina(facQuimicaX, facQuimicaY);
			assertEquals(Retorno.Resultado.OK, ret9.resultado);

			System.out.println("Fac de quimica");
			Double facQuimicaX2 = -34.8883007;
			Double facQuimicaY2 = -56.1850452;
			Retorno ret10 = sistema
					.registrarEsquina(facQuimicaX2, facQuimicaY2);
			assertEquals(Retorno.Resultado.ERROR_2, ret10.resultado);

			System.out.println("Fac de ingenieria");
			Double uniORTX = -34.9050291;
			Double uniORTY = -56.1915827;
			Retorno ret1 = sistema.registrarEsquina(uniORTX, uniORTY);
			assertEquals(Retorno.Resultado.OK, ret1.resultado);

			System.out.println("IMM");
			Double immX = -34.9050291;
			Double immY = -56.1915817;
			Retorno ret2 = sistema.registrarEsquina(immX, immY);
			assertEquals(Retorno.Resultado.OK, ret2.resultado);

			System.out.println("Teatro Solis");
			Double teatroSolisX = -34.9072423;
			Double teatroSolisY = -56.2005342;
			Retorno ret3 = sistema.registrarEsquina(teatroSolisX, teatroSolisY);
			assertEquals(Retorno.Resultado.OK, ret3.resultado);

			System.out.println("Facultad de arquitectura");
			Double facArquitecturaX = -34.913232;
			Double facArquitecturaY = -56.167944;
			Retorno ret4 = sistema.registrarEsquina(facArquitecturaX,
					facArquitecturaY);
			assertEquals(Retorno.Resultado.OK, ret4.resultado);
			
			//gtg2186			
			System.out.println("Aeropuerto");
			Double aeropuertoX = -34.8621083;
			Double aeropuertoY = -56.0613573;
			Retorno ret7 = sistema.registrarEsquina(aeropuertoX, aeropuertoY);
			assertEquals(Retorno.Resultado.OK, ret7.resultado);

			System.out.println("Taberna del diablo");
			Double tabernaDiabloX = -34.9124532;
			Double tabernaDiabloY = -56.1693436;
			Retorno ret5 = sistema.registrarEsquina(tabernaDiabloX,
					tabernaDiabloY);
			assertEquals(Retorno.Resultado.ERROR_1, ret5.resultado);
			
			System.out.println("Museo Nacional de Artes Visuales");
			Double mNAVX = -34.913442;
			Double mNAVY = -56.1678003;
			Retorno ret6 = sistema.registrarEsquina(mNAVX, mNAVY);
			assertEquals(Retorno.Resultado.ERROR_1, ret6.resultado);

			/*	
		

			System.out.println("Solis chico");
			Double solisChicoX = -34.7535082;
			Double solisChicoY = -55.7126396;
			Retorno ret8 = sistema.registrarEsquina(solisChicoX, solisChicoY);
			assertEquals(Retorno.Resultado.OK, ret8.resultado);

			System.out.println("Solis chico dummy");
			Double solisChicoXT = -31.7535082;
			Double solisChicoYT = -51.7126396;
			Retorno ret11 = sistema
					.registrarEsquina(solisChicoXT, solisChicoYT);
			assertEquals(Retorno.Resultado.ERROR_1, ret11.resultado);
			*/
		}
	}
	
	@Test
	public void testVerMapa() {
		
		System.out.println(" test: testVerMapa()");
		ISistema sistema;
		sistema = new Sistema();
		Retorno ret = sistema.inicializarSistema(6);
		if (ret.resultado.equals(Retorno.Resultado.OK)) {

			System.out.println("Fac de quimica");
			Double facQuimicaX = -34.8883007;
			Double facQuimicaY = -56.1850452;
			Retorno ret9 = sistema.registrarEsquina(facQuimicaX, facQuimicaY);
			assertEquals(Retorno.Resultado.OK, ret9.resultado);

			System.out.println("Fac de quimica");
			Double facQuimicaX2 = -34.8883007;
			Double facQuimicaY2 = -56.1850452;
			Retorno ret10 = sistema
					.registrarEsquina(facQuimicaX2, facQuimicaY2);
			assertEquals(Retorno.Resultado.ERROR_2, ret10.resultado);

			System.out.println("Fac de ingenieria");
			Double uniORTX = -34.9050291;
			Double uniORTY = -56.1915827;
			Retorno ret1 = sistema.registrarEsquina(uniORTX, uniORTY);
			assertEquals(Retorno.Resultado.OK, ret1.resultado);

			System.out.println("IMM");
			Double immX = -34.9050291;
			Double immY = -56.1915817;
			Retorno ret2 = sistema.registrarEsquina(immX, immY);
			assertEquals(Retorno.Resultado.OK, ret2.resultado);

			System.out.println("Teatro Solis");
			Double teatroSolisX = -34.9072423;
			Double teatroSolisY = -56.2005342;
			Retorno ret3 = sistema.registrarEsquina(teatroSolisX, teatroSolisY);
			assertEquals(Retorno.Resultado.OK, ret3.resultado);

			System.out.println("Facultad de arquitectura");
			Double facArquitecturaX = -34.913232;
			Double facArquitecturaY = -56.167944;
			Retorno ret4 = sistema.registrarEsquina(facArquitecturaX,
					facArquitecturaY);
			assertEquals(Retorno.Resultado.OK, ret4.resultado);
			
			System.out.println("Aeropuerto");
			Double aeropuertoX = -34.8621083;
			Double aeropuertoY = -56.0613573;
			Retorno ret7 = sistema.registrarEsquina(aeropuertoX, aeropuertoY);
			assertEquals(Retorno.Resultado.OK, ret7.resultado);

			System.out.println("Taberna del diablo");
			Double tabernaDiabloX = -34.9124532;
			Double tabernaDiabloY = -56.1693436;
			Retorno ret5 = sistema.registrarEsquina(tabernaDiabloX,
					tabernaDiabloY);
			assertEquals(Retorno.Resultado.ERROR_1, ret5.resultado);
			
			System.out.println("Museo Nacional de Artes Visuales");
			Double mNAVX = -34.913442;
			Double mNAVY = -56.1678003;
			Retorno ret6 = sistema.registrarEsquina(mNAVX, mNAVY);
			assertEquals(Retorno.Resultado.ERROR_1, ret6.resultado);
			
			// Datos de la prueba
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

			// Estimulo
			Retorno r1 = sistema.registrarMovil(matricula, conductor);
			assertEquals(Retorno.Resultado.OK, r1.resultado); // Deberia retornar OK

			Retorno r2 = sistema.registrarMovil(matricula2, conductor2);
			assertEquals(Retorno.Resultado.OK, r2.resultado); // Deberia retornar OK

			Retorno r3 = sistema.registrarMovil(matricula3, conductor3);
			assertEquals(Retorno.Resultado.OK, r3.resultado); // Deberia retornar OK

			Retorno r4 = sistema.registrarMovil(matricula4, conductor4);
			assertEquals(Retorno.Resultado.OK, r4.resultado); // Deberia retornar OK

			Retorno r5 = sistema.registrarMovil(matricula5, conductor5);
			assertEquals(Retorno.Resultado.OK, r4.resultado); // Deberia retornar OK

			// deshabilitar movil
			Retorno r6 = sistema.deshabilitarMovil(matricula4);
			assertEquals(Retorno.Resultado.OK, r6.resultado);

			// eliminar movil
			//Retorno r7 = sistema.eliminarMovil(matricula2);
			//assertEquals(Retorno.Resultado.OK, r7.resultado);

			
			System.out.println("Asignar Movil a esquina");
			
			
			
			sistema.asignarUbicacionMovil(matricula5, immX, immY);
			
			
			
			sistema.asignarUbicacionMovil(matricula, uniORTX, uniORTY);		
			
			
			
			sistema.asignarUbicacionMovil(matricula3, teatroSolisX, teatroSolisY);
			
			
			
			
			sistema.asignarUbicacionMovil(matricula2, facQuimicaX, facQuimicaY);
			


			sistema.asignarUbicacionMovil(matricula4, tabernaDiabloX, tabernaDiabloY);

						
			
			
			System.out.println("Levanta MAPA");

			

			sistema.verMapa();
		}
	}

	@Test
	public void testD_DestruirSistema() {
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

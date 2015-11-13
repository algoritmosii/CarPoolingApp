package ort.aed2.ob20152;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsSistemaV3 {

	@Test
	public void testInicializarDestruirSistema() {
		ISistema s = new Sistema();
		assertEquals(Retorno.Resultado.OK, s.inicializarSistema(10).resultado);
		assertEquals(Retorno.Resultado.OK, s.destruirSistema().resultado);
	}
	
	@Test
	public void testRegistroMovil() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		//Datos de la prueba
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
	}


	@Test
	public void testRegistroMovilError1() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		// Moviles duplicados en diferentes lugares del ABB
		assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarMovil("SAA1234", "Juan").resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarMovil("IAA1111", "Juan").resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarMovil("NAS1249", "Juan").resultado);
	}
	
	@Test
	public void testDeshabilitarMovil() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		//Deshabilitar moviles
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("SAA1234").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("AAB4561").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("IAA1111").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("NAS1249").resultado);
		
	}
	
	@Test
	public void testDeshabilitarMovilErrores() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		//Deshabilitar moviles
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("SAA1234").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("AAB4561").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("IAA1111").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("NAS1249").resultado);
		//Movil no registrado
		assertEquals(Retorno.Resultado.ERROR_1, sistema.deshabilitarMovil("NOE0000").resultado);
		//Movil ya deshabilitado
		assertEquals(Retorno.Resultado.ERROR_2, sistema.deshabilitarMovil("SAA1234").resultado);
	}

	@Test
	public void testEliminarMovil() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		//Eliminar moviles
		assertEquals(Retorno.Resultado.OK, sistema.eliminarMovil("SAA1234").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.eliminarMovil("AAB4561").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.eliminarMovil("IAA1111").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.eliminarMovil("NAS1249").resultado);
		//Se pueden volver a registrar los mismos 4
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
	}
	
	@Test
	public void testEliminarMovilError1() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		//No existe movil
		assertEquals(Retorno.Resultado.ERROR_1, sistema.eliminarMovil("NOE0000").resultado);	
	}
	
	@Test
	public void testHabilitarMovil() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		//Deshabilitar moviles
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("SAA1234").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("AAB4561").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("IAA1111").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("NAS1249").resultado);
		//Habilitar moviles
		assertEquals(Retorno.Resultado.OK, sistema.habilitarMovil("SAA1234").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.habilitarMovil("AAB4561").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.habilitarMovil("IAA1111").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.habilitarMovil("NAS1249").resultado);
		//Deshabilitar moviles de nuevo tienen que dar todos OK
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("SAA1234").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("AAB4561").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("IAA1111").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("NAS1249").resultado);
	}
	
	@Test
	public void testHabilitarMovilErrores() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		//Movil que no existe
		assertEquals(Retorno.Resultado.ERROR_1, sistema.habilitarMovil("NOE0000").resultado);	
		//Movil que ya esta habilitado
		assertEquals(Retorno.Resultado.ERROR_2, sistema.habilitarMovil("SBW6410").resultado);
	}
	
	@Test
	public void testBuscarMovil() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		//Datos de la prueba
		String matricula = "SAA1234";
		String nombre = "Omar";
		
		Retorno ret = sistema.registrarMovil(matricula, nombre);
		assertEquals(Retorno.Resultado.OK, ret.resultado);	
		ret = sistema.buscarMovil(matricula);
		assertEquals(Retorno.Resultado.OK, ret.resultado);	
		// El valor string deberia contener los datos del vendedor ingresado
		assertTrue(ret.valorString.contains(matricula)); 
		assertTrue(ret.valorString.contains(nombre));
	}
	
	@Test
	public void asignarUbicacionMovil() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909039, -56.195530).resultado);//P1
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908951, -56.194500).resultado);//P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908880, -56.193299).resultado);//P3
			
		//Moviles en esquinas
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA2211", "Ana").resultado);
		//Asignar moviles OK
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("SAA1234", -34.909039, -56.195530).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("AAB4561", -34.908951, -56.194500).resultado);
		
		//Esquina no existe
		assertEquals(Retorno.Resultado.ERROR_1, sistema.asignarUbicacionMovil("IAA2211", -34.000000, -56.000000).resultado);
		//Esquina ya ocupada por otro movil
		assertEquals(Retorno.Resultado.ERROR_2, sistema.asignarUbicacionMovil("IAA2211", -34.909039, -56.195530).resultado);
		//Matricula no existe
		assertEquals(Retorno.Resultado.ERROR_3, sistema.asignarUbicacionMovil("NOE0000", -34.908880, -56.193299).resultado);
	}
	
	@Test
	public void testListadoMoviles() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(10);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("NAS1249", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SBW6410", "Jose").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("MAA2222", "Pedro").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA1111", "Luis").resultado);
		
		Retorno res = sistema.informeMoviles();
		assertEquals(Retorno.Resultado.OK, res.resultado);
		//Validar que estan todos los moviles
		assertTrue(res.valorString.contains("SAA1234"));
		assertTrue(res.valorString.contains("AAB4561"));
		assertTrue(res.valorString.contains("NAS1249"));
		assertTrue(res.valorString.contains("SBW6410"));
		assertTrue(res.valorString.contains("MAA2222"));
		assertTrue(res.valorString.contains("IAA1111"));
		//Validar que estan ordenados
		assertTrue(res.valorString.indexOf("SBW6410")>res.valorString.indexOf("SAA1234"));
		assertTrue(res.valorString.indexOf("SAA1234")>res.valorString.indexOf("NAS1249"));
		assertTrue(res.valorString.indexOf("NAS1249")>res.valorString.indexOf("MAA2222"));
		assertTrue(res.valorString.indexOf("MAA2222")>res.valorString.indexOf("IAA1111"));
		assertTrue(res.valorString.indexOf("IAA1111")>res.valorString.indexOf("AAB4561"));
		
	}

	//TEST MAPA
	
	@Test
	public void testRegistrarEsquinas() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(5);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105104,-58.0759192).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105188,-58.0759192).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105188,-58.0759188).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3102222,-58.0759192).resultado);
		//Coordenadas duplicadas
		assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarEsquina(-32.3102222,-58.0759192).resultado);
		//Cantidad maxima de puntos
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105133,-58.0759222).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarEsquina(-32.3105144,-58.0759555).resultado);
	}
	
	@Test
	public void testEliminarEsquina() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105104,-58.0759182).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105120,-58.0759188).resultado);

		//Eliminar esquina
		assertEquals(Retorno.Resultado.OK, sistema.eliminarEsquina(-32.3105104,-58.0759182).resultado);
		//Tengo que poder darla de alta nuevamente
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105104,-58.0759182).resultado);
	}
	
	@Test
	public void testEliminarEsquinaErrores() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);

		//Eliminar esquina que no existe
		assertEquals(Retorno.Resultado.ERROR_1, sistema.eliminarEsquina(-32.3105104,-58.0759182).resultado); 

	}
	
	
	@Test
	public void testTramos() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105104,-58.0759192).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105100,-58.0759192).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105100,-58.0759100).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3102222,-58.0759192).resultado);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105134,-58.0759162).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105108,-58.0759152).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105102,-58.0759102).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3102202,-58.0759143).resultado);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105104,-58.0759182).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105120,-58.0759188).resultado);
		
		//Peso invalido
		assertEquals(Retorno.Resultado.ERROR_1 , sistema.registrarTramo(-32.3105104,-58.0759192, -32.3105100,-58.0759192, -3).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarTramo(-32.3105104,-58.0759192, -32.3105100,-58.0759192, 0).resultado);
		//No existe el punto de destino
		assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarTramo(-32.3105104,-58.0759192, -32.3105200,-58.0759200, 80).resultado);
		//No existe el punto de origen
		assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarTramo(-32.3105200,-58.0759200, -32.3105104,-58.0759192, 80).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105104,-58.0759192, -32.3105100,-58.0759192, 80).resultado);
		//Tramo duplicado
		assertEquals(Retorno.Resultado.ERROR_3, sistema.registrarTramo(-32.3105104,-58.0759192, -32.3105100,-58.0759192, 100).resultado);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105100,-58.0759100, -32.3102222,-58.0759192, 180).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105134,-58.0759162, -32.3105108,-58.0759152, 280).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105108,-58.0759152, -32.3102202,-58.0759143, 380).resultado);
		
	}
	
	
	@Test
	public void testEliminarTramos() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105104,-58.0759192).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105100,-58.0759192).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105100,-58.0759100).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3102222,-58.0759192).resultado);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105134,-58.0759162).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105108,-58.0759152).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105102,-58.0759102).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3102202,-58.0759143).resultado);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105104,-58.0759182).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-32.3105120,-58.0759188).resultado);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105104,-58.0759192, -32.3105100,-58.0759192, 80).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105100,-58.0759100, -32.3102222,-58.0759192, 180).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105134,-58.0759162, -32.3105108,-58.0759152, 280).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105108,-58.0759152, -32.3102202,-58.0759143, 380).resultado);
		
		//Eliminar tramo OK
		assertEquals(Retorno.Resultado.OK, sistema.eliminarTramo(-32.3105108,-58.0759152, -32.3102202,-58.0759143).resultado);
		//No existe una de las esquinas
		assertEquals(Retorno.Resultado.ERROR_1, sistema.eliminarTramo(-38.3105108,-51.0759152, -32.3102202,-58.0759143).resultado);
		// No existe tramo
		assertEquals(Retorno.Resultado.ERROR_2, sistema.eliminarTramo(-32.3105108,-58.0759152, -32.3102202,-58.0759143).resultado); 
		
	}
	
	
	
	@Test
	public void testMovilesEnRadio() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909039, -56.195530).resultado);//P1
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908951, -56.194500).resultado);//P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908880, -56.193299).resultado);//P3
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909980, -56.195498).resultado);//P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909910, -56.194372).resultado);//P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909813, -56.193202).resultado);//P6
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910913, -56.195370).resultado);//P7
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910728, -56.193116).resultado);//P9
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.908951, -56.194500, 7).resultado);//P1-P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.909980, -56.195498, 2).resultado);//P1-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.908880, -56.193299, 8).resultado);//P2-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.909910, -56.194372, 12).resultado);//P2-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.908880, -56.193299, 3).resultado);//P6-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.909910, -56.194372, 18).resultado);//P6-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.910728, -56.193116, 12).resultado);//P6-P9
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.909980, -56.195498, 2).resultado);//P5-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.909980, -56.195498, 6).resultado);//P7-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.910886, -56.194254, 10).resultado);//P7-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.910886, -56.194254, 3).resultado);//P5-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910728, -56.193116, -34.910886, -56.194254, 10).resultado);//P9-P8
		
		//Moviles en esquinas
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("IAA2211", "Ana").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("SAA1234", -34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("AAB4561", -34.910913, -56.195370).resultado);//P7
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("IAA2211", -34.910728, -56.193116).resultado);//P9
		
		// Moviles en radio 22 desde P3: P9 y P8, en ese orden
		String movilEsperado = "IAA2211;15;Ana|SAA1234;22;Omar";
		Retorno res = sistema.verMovilesEnRadio(-34.908880, -56.193299, 22);	//desde P3
		assertEquals(Retorno.Resultado.OK, res.resultado);
		assertEquals(movilEsperado, res.valorString.replace(" ", ""));
	}
	
		
	@Test
	public void testMovilMasCercanoSimple() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909039, -56.195530).resultado);//P1
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908951, -56.194500).resultado);//P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908880, -56.193299).resultado);//P3
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909980, -56.195498).resultado);//P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909910, -56.194372).resultado);//P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909813, -56.193202).resultado);//P6
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910913, -56.195370).resultado);//P7
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910728, -56.193116).resultado);//P9
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.908951, -56.194500, 7).resultado);//P1-P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.909980, -56.195498, 2).resultado);//P1-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.908880, -56.193299, 8).resultado);//P2-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.909910, -56.194372, 12).resultado);//P2-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.908880, -56.193299, 3).resultado);//P6-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.909910, -56.194372, 18).resultado);//P6-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.910728, -56.193116, 12).resultado);//P6-P9
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.909980, -56.195498, 2).resultado);//P5-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.909980, -56.195498, 6).resultado);//P7-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.910886, -56.194254, 10).resultado);//P7-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.910886, -56.194254, 3).resultado);//P5-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910728, -56.193116, -34.910886, -56.194254, 10).resultado);//P9-P8
		
		//Moviles en esquinas
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("SAA1234", -34.908951, -56.194500).resultado);//P2
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("AAB4561", -34.909813, -56.193202).resultado);//P6
		
		// Movil mas cercano desde P3: P3-P6 costo 3
		String movilEsperado = "AAB4561;3;Juan";
		Retorno res = sistema.movilMasCercano(-34.908880, -56.193299);	//desde P3
		assertEquals(Retorno.Resultado.OK, res.resultado);
		assertEquals(movilEsperado, res.valorString.replace(" ", ""));
	}
	
	
	@Test
	public void testMovilMasCercanoVariasEsquinas() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909039, -56.195530).resultado);//P1
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908951, -56.194500).resultado);//P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908880, -56.193299).resultado);//P3
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909980, -56.195498).resultado);//P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909910, -56.194372).resultado);//P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909813, -56.193202).resultado);//P6
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910913, -56.195370).resultado);//P7
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910728, -56.193116).resultado);//P9
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.908951, -56.194500, 7).resultado);//P1-P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.909980, -56.195498, 2).resultado);//P1-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.908880, -56.193299, 8).resultado);//P2-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.909910, -56.194372, 12).resultado);//P2-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.908880, -56.193299, 3).resultado);//P6-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.909910, -56.194372, 18).resultado);//P6-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.910728, -56.193116, 12).resultado);//P6-P9
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.909980, -56.195498, 2).resultado);//P5-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.909980, -56.195498, 6).resultado);//P7-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.910886, -56.194254, 10).resultado);//P7-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.910886, -56.194254, 3).resultado);//P5-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910728, -56.193116, -34.910886, -56.194254, 10).resultado);//P9-P8
		
		//Moviles en esquinas
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("SAA1234", -34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("AAB4561", -34.910913, -56.195370).resultado);//P7
		
		// Movil mas cercano desde P3: P3-P2-P1-P4-P5-P8 costo 22
		String movilEsperado = "SAA1234;22;Omar";
		Retorno res = sistema.movilMasCercano(-34.908880, -56.193299);	//P3
		assertEquals(Retorno.Resultado.OK, res.resultado);
		assertEquals(movilEsperado, res.valorString.replace(" ", ""));
	}
	
	@Test
	public void testMovilMasCercanoIgnoraDeshabilitado() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909039, -56.195530).resultado);//P1
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908951, -56.194500).resultado);//P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908880, -56.193299).resultado);//P3
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909980, -56.195498).resultado);//P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909910, -56.194372).resultado);//P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909813, -56.193202).resultado);//P6
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910913, -56.195370).resultado);//P7
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910728, -56.193116).resultado);//P9
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.908951, -56.194500, 7).resultado);//P1-P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909039, -56.195530, -34.909980, -56.195498, 2).resultado);//P1-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.908880, -56.193299, 8).resultado);//P2-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.909910, -56.194372, 12).resultado);//P2-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.908880, -56.193299, 3).resultado);//P6-P3
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.909910, -56.194372, 18).resultado);//P6-P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909813, -56.193202, -34.910728, -56.193116, 12).resultado);//P6-P9
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.909980, -56.195498, 2).resultado);//P5-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.909980, -56.195498, 6).resultado);//P7-P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910913, -56.195370, -34.910886, -56.194254, 10).resultado);//P7-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.909910, -56.194372, -34.910886, -56.194254, 3).resultado);//P5-P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.910728, -56.193116, -34.910886, -56.194254, 10).resultado);//P9-P8
		
		//Moviles en esquinas
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("SAA1234", "Omar").resultado);	
		assertEquals(Retorno.Resultado.OK, sistema.registrarMovil("AAB4561", "Juan").resultado);
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("SAA1234", -34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.asignarUbicacionMovil("AAB4561", -34.910913, -56.195370).resultado);//P7
		//El mas cercano queda deshabilitado, deberia ir por el P7
		assertEquals(Retorno.Resultado.OK, sistema.deshabilitarMovil("SAA1234").resultado);
		
		// Movil mas cercano desde P3: P3-P2-P1-P4-P7 costo 23
		String movilEsperado = "AAB4561;23;Juan";
		Retorno res = sistema.movilMasCercano(-34.908880, -56.193299);	//saliendo desde P3
		assertEquals(Retorno.Resultado.OK, res.resultado);
		assertEquals(movilEsperado, res.valorString.replace(" ", ""));
	}
	
	@Test
	public void testMovilMasCercanoErrores() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(5);
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908951, -56.194500).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908880, -56.193299).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910913, -56.195370).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.908880, -56.193299, 7).resultado);
		assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-34.908951, -56.194500, -34.910913, -56.195370, 7).resultado);
		//No existe esquina
		assertEquals(Retorno.Resultado.ERROR_1, sistema.movilMasCercano(-34.000000, -56.000000).resultado);
		//No tengo moviles disponibles, debo retornar el string vacio
		Retorno res = sistema.movilMasCercano(-34.908951, -56.194500);
		assertEquals(Retorno.Resultado.OK, res.resultado);
		assertEquals("", res.valorString.replace(" ", ""));
	}
	
	@Test
	public void testMapa() {
		ISistema sistema = new Sistema();
		sistema.inicializarSistema(20);
		
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909039, -56.195530).resultado);//P1
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908951, -56.194500).resultado);//P2
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.908880, -56.193299).resultado);//P3
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909980, -56.195498).resultado);//P4
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909910, -56.194372).resultado);//P5
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.909813, -56.193202).resultado);//P6
		
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910913, -56.195370).resultado);//P7
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910886, -56.194254).resultado);//P8
		assertEquals(Retorno.Resultado.OK, sistema.registrarEsquina(-34.910728, -56.193116).resultado);//P9
		
		assertEquals(Retorno.Resultado.OK, sistema.verMapa().resultado);
	}
		

}
package test;

import ort.aed2.ob20152.ISistema;
import ort.aed2.ob20152.Retorno;
import ort.aed2.ob20152.Sistema;

public class Inicio {

	static ISistema sistema;

	public static void main(String[] args) {
		sistema = new Sistema();
		testInicializarSistema();
		testDestruirSistema();

	}

	public static void testInicializarSistema() {
		Retorno ret = sistema.inicializarSistema(10);
		if (ret.resultado.equals(Retorno.Resultado.OK)) {
			System.out.println(" Sistema iniciado");
		}
	}

	public static void testDestruirSistema() {
		Retorno ret = sistema.destruirSistema();
		if (ret.resultado.equals(Retorno.Resultado.OK)) {
			System.out.println(" Sistema destruido");
		}
	}
}

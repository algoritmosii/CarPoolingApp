package mapa;

import ort.aed2.ob20152.Retorno;
import listaDoble.Lista;

public class HashEsquinas {

	int tam;
	Lista[] tabla;

	public HashEsquinas(int t) {
		this.tam = t;
		this.tabla = new Lista[t];
		for (int i = 0; i < tam; i++) {
			tabla[i] = new Lista();
		}
	}

	private int h(Integer llave) {
		int clave = llave % tam;
		System.out.println("CLAVE> " + clave);
		return clave;
	}

	public boolean pertenece(Integer llave, String coordenadas) {
		System.out.println("pertenece>llave>" + llave + ":: coord"
				+ coordenadas);
		int pos = h(llave);
		return tabla[pos].existe(coordenadas);
	}

	/*
	 * public boolean insertar(Double coordX, Double coordY, int cantNodos) {
	 * String coordenadas = coordX + "-" + coordY; int llave = getLlave(coordX,
	 * coordY); int cantActual = getCantNodos(); if (cantNodos > cantActual) {
	 * int pos = h(llave); tabla[pos].insertarInicio(coordenadas); if
	 * (pertenece(llave, coordenadas)) { return true; } } return false; }
	 */

	public Retorno insertar(Double coordX, Double coordY, int cantNodos) {
		Retorno r = new Retorno();
		String coordenadas = coordX + "*" + coordY;
		int llave = getLlave(coordX, coordY);
		int cantEsquinasRegistradas = getCantEsquinas();

		if (cantNodos > cantEsquinasRegistradas) {
			System.out.println("insertar >> CantNodos: " + cantNodos
					+ " cantEsquinasRegistradas: " + cantEsquinasRegistradas);
			r = registrarEsquina(llave, coordenadas);
		} else {
			System.out
					.println("insertar >> Error, menos cantNods q esquinasReg || CantNodos: "
							+ cantNodos
							+ " cantEsquinasRegistradas: "
							+ cantEsquinasRegistradas);
			r.resultado = Retorno.Resultado.ERROR_1;
		}
		return r;
	}

	private Retorno registrarEsquina(int llave, String coordenadas) {
		Retorno r = new Retorno();
		if (pertenece(llave, coordenadas)) {
			r.resultado = Retorno.Resultado.ERROR_2;
		} else {
			int pos = h(llave);
			tabla[pos].insertarInicio(coordenadas);
			tabla[pos].imprimir(pos);
			if (pertenece(llave, coordenadas)) {
				r.resultado = Retorno.Resultado.OK;
			}
		}
		return r;
	}

	private int getCantEsquinas() {
		int r = 0;
		for (int i = 0; i < tam; i++) {
			r = r + this.tabla[i].getCantNodos();
		}
		System.out.println("getCantEsquinas:" + r);
		return r;
	}

	private Integer getLlave(Double coordX, Double coordY) {
		String r;
		Integer salida;
		String auxX = String.valueOf(coordX);
		auxX = auxX.replace("*", "");
		auxX = auxX.replace(".", "");
		auxX = auxX.replace("-", "");
		auxX = auxX.substring(4, 8);

		String auxY = String.valueOf(coordY);
		auxY = auxY.replace("*", "");
		auxY = auxY.replace(".", "");
		auxY = auxY.replace("-", "");
		auxY = auxY.substring(4, 8);

		r = auxX + "" + auxY;
		salida = Integer.parseInt(r.trim());
		return salida;
	}
}

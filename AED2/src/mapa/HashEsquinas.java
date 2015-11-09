package mapa;

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

	private int h(String llaveRaw) {
		String llave = llaveRaw.replace(".", "");
		llave = llave.replace("-", "");
		return Integer.parseInt(llave) % tam;
	}

	public boolean pertenece(EsquinaNodo esquina) {
		double coordX = esquina.getCoordX();
		double coordY = esquina.getCoordY();
		String llaveAInsertar = coordX + "-" + coordY;
		int pos = h(llaveAInsertar);
		return tabla[pos].existe(llaveAInsertar);
	}

	public boolean pertenece(String llave) {
		int pos = h(llave);
		return tabla[pos].existe(llave);
	}

	public boolean insertar(Double coordX, Double coordY) {
		String llave = coordX + "-" + coordY;
		int pos = h(llave);
		tabla[pos].insertarInicio(llave);
		if (pertenece(llave)) {
			return true;
		}
		return false;
	}

}

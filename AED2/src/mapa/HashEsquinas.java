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
	
	private int h(Integer llave) {

		return llave % tam;
	}
	
	public boolean pertenece(Integer llave, String coordenadas) {
		int pos = h(llave);
		return tabla[pos].existe(coordenadas);
	}

	public boolean insertar(Double coordX, Double coordY) {
		String coordenadas = coordX + "-" + coordY;
		int llave = getLlave(coordX, coordY);
		int pos = h(llave);
		tabla[pos].insertarInicio(coordenadas);
		if (pertenece(llave, coordenadas)) {
			return true;
		}
		return false;
	}

	private Integer getLlave(Double coordX, Double coordY) {
		String r;
		Integer salida;
		String auxX = String.valueOf(coordX);
		auxX = auxX.replace(".", "");
		auxX = auxX.replace("-", "");
		auxX = auxX.substring(5, 8);
		
		String auxY = String.valueOf(coordY);
		auxY = auxY.replace(".", "");
		auxY = auxY.replace("-", "");
		auxY = auxY.substring(5, 8);
		
		r = auxX + "" + auxY;
		salida = Integer.parseInt(r.trim());
		return salida;
	}
}

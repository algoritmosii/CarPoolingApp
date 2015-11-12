package mapa;

import ort.aed2.ob20152.Retorno;
import listaDoble.Lista;
import listaDoble.NodoLD;

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
		System.out.println("tam" + tam);
		int clave = llave % tam;
		return clave;
	}

	public boolean pertenece(Integer llave, String coordenadas) {
		int pos = h(llave);
		return tabla[pos].existe(coordenadas);
	}

	public Retorno insertar(Double coordX, Double coordY, int cantNodos) {
		Retorno r = new Retorno();
		String coordenadas = coordX + "*" + coordY;
		int llave = getLlave(coordX, coordY);
		int cantEsquinasRegistradas = getCantEsquinas();

		if (cantNodos > cantEsquinasRegistradas) {
			r = registrarEsquina(llave, coordenadas);
		} else {
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

	public Lista nodos() {
		Lista nodos = new Lista();
		String[] nodosAux;
		int tablaLen = tabla.length;
		String elemento = null;
		for (int i = 0; i < tablaLen; i++) {
			nodosAux = this.tabla[i].getNodosStr();
			// iterar en nodosAux y agregar elenmentos a nodos
			int len = nodosAux.length;
			for (int x = 0; x < len; x++) {
				elemento = nodosAux[x];
				nodos.insertarInicio(elemento);
				System.out.println(" ELEMENTO: " + elemento);
			}
		}
		return nodos;
	}

	public boolean existeUnMovilEnXY(Double coordX, Double coordY) {
		int llave = getLlave(coordX, coordY);
		String coordenadas = coordX + "*" + coordY;
		// hacer otro pertenece y chequear que la matricula no sea null

		if (existeMovil(llave, coordenadas)) {
			return true;
		}
		return false;
	}

	private boolean existeMovil(int llave, String coordenadas) {
		int pos = h(llave);
		return tabla[pos].existeMovil(coordenadas);

	}

	public boolean existeEsquinaXY(Double coordX, Double coordY) {
		int llave = getLlave(coordX, coordY);
		String coordenadas = coordX + "*" + coordY;
		if (pertenece(llave, coordenadas)) {
			return true;
		}
		return false;
	}

	public boolean asignarUbicacionAMovil(Double coordX, Double coordY, String matricula) {
		int llave = getLlave(coordX, coordY);
		String coordenadas = coordX + "*" + coordY;
		int pos = h(llave);
		if (tabla[pos].asignarMovilAEsquina(coordenadas, matricula)) {
			return true;
		}
		return false;
	}
}

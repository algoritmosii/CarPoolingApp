package mapa;

import ort.aed2.ob20152.Retorno;

public class MapaGrafo implements IGrafoMapa {

	private int size;
	private int cantNodos;
	private ListaVert[] verticesAdyacentes;
	private boolean[] nodosUsados;
	private HashEsquinas esquinas;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	/*
	 * 1. preguntar al profe si el tam de hash puede ser el primo cercano a cantPuntos? 
	 *    asi quedaria lo suficientemente grande pero no gigante..
	 */
	@Override
	public boolean crearGrafoVacio(int maxNodos) {
		this.size = 0;
		this.cantNodos = maxNodos;
		int capacidad = getPrimoCercano(maxNodos);
		this.verticesAdyacentes = new ListaVert[this.cantNodos + 1];
		try {
			for (int i = 0; i < this.cantNodos; i++) {
				this.verticesAdyacentes[i] = new ListaVert();
			}
			this.esquinas = new HashEsquinas(capacidad);
			this.nodosUsados = new boolean[this.cantNodos + 1];
			return true;
		} catch (Exception e) {
			// "Log: Error - crearGrafoVacio:" + e.toString();
		}
		return false;
	}

	private int getPrimoCercano(int maxNodos) {
		int testPrimo =maxNodos;
		if (testPrimo % 2 == 0) {
			testPrimo = maxNodos - 1;
		}
		return testPrimo;
	}

	@Override
	public boolean destruirGrafo() {
		try {
			this.verticesAdyacentes = new ListaVert[0];
			this.nodosUsados = new boolean[0];
			int cantVert = verticesAdyacentes.length;
			for (int i = 0; i < cantVert; i++) {
				this.verticesAdyacentes[i] = new ListaVert();
			}

			if (this.verticesAdyacentes.length == 0) {
				if (this.nodosUsados.length == 0) {
					this.cantNodos = 0;
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println("Log: Error - destruirGrafo:" + e.toString());
		}
		return false;
	}

	@Override
	public void agregarArista(int origen, int destino, int peso) {
		this.verticesAdyacentes[origen].insertarInicio(destino, peso);
	}

	public Retorno registrarEsquina(Double coordX, Double coordY) {
		Retorno r = new Retorno();
		if(this.esquinas.insertar(coordX,coordY))
			r.resultado = Retorno.Resultado.OK;
		else
			r.resultado = Retorno.Resultado.ERROR_1;
		return r;
	}
	
	@Override
	public void agregarVertice(int v) {
		this.nodosUsados[v] = true;
		this.size++;
	}

	/*
	 * @Override public void eliminarArista(int origen, int destino) {
	 * this.verticesAdyacentes[origen].borrar(destino); }
	 */
	public boolean esVacio() {
		return this.size == 0;
	}

	/*
	 * public boolean sonAdyacentes(EsquinaNodo a, EsquinaNodo b) { return
	 * this.verticesAdyacentes[a.get].existe(b); }
	 * 
	 * @Override public void eliminarVertice(int v) { this.nodosUsados[v] =
	 * false; this.size--;
	 * 
	 * this.verticesAdyacentes[v] = new ListaVert(); for (int i = 0; i <
	 * this.cantNodos; i++) { this.verticesAdyacentes[i].borrar(v); } }
	 */
	@Override
	public ListaVert verticesAdyacentes(int v) {
		return this.verticesAdyacentes[v];
	}

	@Override
	public boolean existeVertice(int v) {
		return this.nodosUsados[v];
	}

	@Override
	public boolean sonAdyacentes(int origen, int destino) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

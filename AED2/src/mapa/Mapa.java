package mapa;

public class Mapa implements IGrafoMapa {

	private int size;
	private int cantNodos;
	private ListaVert[] verticesAdyacentes;
	private boolean[] nodosUsados;

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

	@Override
	public boolean crearGrafoVacio(int maxNodos) {
		this.size = 0;
		this.cantNodos = maxNodos;
		this.verticesAdyacentes = new ListaVert[this.cantNodos + 1];
		try {
			for (int i = 0; i < this.cantNodos; i++) {
				this.verticesAdyacentes[i] = new ListaVert();
			}
			this.nodosUsados = new boolean[this.cantNodos + 1];
			if (this.nodosUsados[0] == true) {
				System.out.println(" el booleano inicializa en true");
			} else {
				System.out.println(" el booleano inicializa en false");
			}
			return true;
		} catch (Exception e) {
			// "Log: Error - crearGrafoVacio:" + e.toString();
		}
		return false;
	}

	@Override
	public boolean destruirGrafo() {
		try {
			this.verticesAdyacentes = null;
			this.nodosUsados = new boolean[0];

			if (this.nodosUsados.length == 0) {
				if (this.verticesAdyacentes == null) {
					System.out.println("destruido");
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

	@Override
	public void agregarVertice(int v) {
		this.nodosUsados[v] = true;
		this.size++;
	}

	@Override
	public void eliminarArista(int origen, int destino) {
		this.verticesAdyacentes[origen].borrar(destino);
	}

	public boolean esVacio() {
		return this.size == 0;
	}

	public boolean sonAdyacentes(int a, int b) {
		return this.verticesAdyacentes[a].existe(b);
	}

	@Override
	public void eliminarVertice(int v) {
		this.nodosUsados[v] = false;
		this.size--;

		this.verticesAdyacentes[v] = new ListaVert();
		for (int i = 0; i < this.cantNodos; i++) {
			this.verticesAdyacentes[i].borrar(v);
		}
	}

	@Override
	public ListaVert verticesAdyacentes(int v) {
		return this.verticesAdyacentes[v];
	}

	@Override
	public boolean existeVertice(int v) {
		return this.nodosUsados[v];
	}

	@Override
	public boolean esConexo() {
		// TODO Auto-generated method stub
		return false;
	}
}

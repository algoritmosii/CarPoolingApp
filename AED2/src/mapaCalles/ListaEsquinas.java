package mapaCalles;

public class ListaEsquinas implements ILista {

	EsquinaNodoLista inicio;
	int peso;

	public EsquinaNodoLista getInicio() {
		return inicio;
	}

	public void setInicio(EsquinaNodoLista inicio) {
		this.inicio = inicio;
	}

	public ListaEsquinas() {
		this.setInicio(null);
	}

	@Override
	public void insertarInicio(int dest, int peso) {
		EsquinaNodoLista nuevoNodo = new EsquinaNodoLista();
		nuevoNodo.setSiguiente(this.inicio);
		this.inicio = nuevoNodo;
	}

	@Override
	public boolean esVacia() {
		return this.inicio == null;
	}

	@Override
	public void imprimir() {
		if (this.esVacia()) {
			System.out.println("Lista vacia");
		} else {
			EsquinaNodoLista nodoAux = this.inicio;
			while (nodoAux != null) {
				System.out.println("X: " + nodoAux.getCoordX() + "-" + "Y: "
						+ nodoAux.getCoordY());
				nodoAux = nodoAux.getSiguiente();
			}
		}
	}

	@Override
	public void vaciarLista() {
		if (!this.esVacia()) {
			borrarInicio();
		}
	}

	@Override
	public void borrarInicio() {
		if (!this.esVacia())
			this.inicio = this.inicio.getSiguiente();
	}

	@Override
	public boolean existe(double x, double y) {
		EsquinaNodoLista nodoAux = this.inicio;
		while (nodoAux != null) {
			if (nodoAux.getCoordX() == x && nodoAux.getCoordY() == y) {
				return true;
			}
			nodoAux = nodoAux.getSiguiente();
		}
		return false;
	}

}

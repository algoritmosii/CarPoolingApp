package mapa;

public class ListaVert implements ILista {

	VerticeNodo inicio;
	int peso;

	public VerticeNodo getInicio() {
		return inicio;
	}

	public void setInicio(VerticeNodo inicio) {
		this.inicio = inicio;
	}

	public ListaVert() {
		this.setInicio(null);
	}

	@Override
	public void insertarInicio(int dest, int peso) {
		VerticeNodo nuevoNodo = new VerticeNodo();
		nuevoNodo.setSiguiente(this.inicio);
		nuevoNodo.getSiguiente().setAnterior(nuevoNodo);
		nuevoNodo.setAnterior(null);
		nuevoNodo.setDestino(dest);
		nuevoNodo.setPeso(peso);
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
			VerticeNodo nodoAux = this.inicio;
			while (nodoAux != null) {
				System.out.println(nodoAux.getDato());
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
	public boolean existe(int valor) {
		VerticeNodo nodoAux = this.inicio;
		while (nodoAux != null) {
			if (nodoAux.getDato() == valor) {
				return true;
			}
			nodoAux = nodoAux.getSiguiente();
		}
		return false;
	}

	@Override
	public VerticeNodo buscarElemento(int valor) {
		VerticeNodo nodoAux = this.inicio;
		while (nodoAux != null) {
			if (nodoAux.getDato() == valor) {
				return nodoAux;
			}
			nodoAux = nodoAux.getSiguiente();
		}
		return nodoAux;
	}

	@Override
	public void borrar(int valor) {
		VerticeNodo nodoAux = buscarElemento(valor);
		if (nodoAux != null) {
			nodoAux.getAnterior().setSiguiente(nodoAux.getSiguiente());
			nodoAux.getSiguiente().setAnterior(nodoAux.getAnterior());
		}
	}
}

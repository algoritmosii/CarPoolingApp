package listaDoble;

public class Lista implements IListaD {

	NodoLD inicio;

	public NodoLD getInicio() {
		return inicio;
	}

	public void setInicio(NodoLD inicio) {
		this.inicio = inicio;
	}

	public Lista() {
		this.setInicio(null);
	}

	@Override
	public void insertarInicio(String dato) {
		if (!existe(dato)) {
			NodoLD nuevoNodo = new NodoLD(dato);
			nuevoNodo.setSiguiente(this.inicio);
			this.inicio = nuevoNodo;
		} else {
			System.out.println("existe dato: " + dato);
		}
	}

	@Override
	public boolean esVacia() {
		return this.inicio == null;
	}

	@Override
	public void imprimir(int pos) {
		System.out.println("Imprimir Lista de pos" + pos);
		if (this.esVacia()) {
			System.out.println("Lista vacia");
		} else {
			NodoLD nodoAux = this.inicio;
			while (nodoAux != null) {
				System.out.println(nodoAux.getElemento());
				nodoAux = nodoAux.getSiguiente();
			}
		}
	}

	@Override
	public int getCantNodos() {
		int cant = 0;
		if (this.esVacia()) {
			return 0;
		} else {
			NodoLD nodoAux = this.inicio;
			while (nodoAux != null) {
				cant++;
				System.out.println(nodoAux.getElemento());
				nodoAux = nodoAux.getSiguiente();
			}
			System.out.println("getCantNodos: " + cant);
		}
		return cant;
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
	public boolean existe(String valor) {
		NodoLD nodoAux = this.inicio;
		while (nodoAux != null) {
			if (nodoAux.getElemento().equals(valor)) {
				System.out.println("Lista.existe=true. Valor: " + valor);
				return true;
			}
			nodoAux = nodoAux.getSiguiente();
		}
		System.out.println("Lista.existe=false. Valor: " + valor);
		return false;
	}

	@Override
	public NodoLD buscarElemento(String valor) {
		NodoLD nodoAux = this.inicio;
		while (nodoAux != null) {
			if (nodoAux.getElemento() == valor) {
				return nodoAux;
			}
			nodoAux = nodoAux.getSiguiente();
		}
		return nodoAux;
	}
}

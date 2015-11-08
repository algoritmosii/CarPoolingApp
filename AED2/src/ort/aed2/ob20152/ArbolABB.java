package ort.aed2.ob20152;

public class ArbolABB {

	private NodoABB raiz;
	private int cantNodos;
	private int cantHojas;
	private int peso;
	private int altura;

	public ArbolABB() {
	}

	public void insertar(Movil m) {
		NodoABB n = new NodoABB(m);
		raiz = insertar(n.getDato(), raiz);
	}

	// Inserta un nodo manteniendo el orden del ABB
	private NodoABB insertar(Movil m, NodoABB a) {
		if (a == null)
			a = new NodoABB(m);
		else if (m.getMatricula().compareTo(a.getDato().getMatricula()) < 0)
			a.nodoIzq = insertar(m, a.nodoIzq);
		else if (m.getMatricula().compareTo(a.getDato().getMatricula()) > 0)
			a.nodoDer = insertar(m, a.nodoDer);
		return a;
	}

	public NodoABB buscar(String matricula) {
		return buscar(this.raiz, matricula);
	}

	private NodoABB buscar(NodoABB n, String matricula) {
		if (n == null) {
			return null;
		}
		if (n.getDato().getMatricula() == matricula) {
			return n;
		}

		NodoABB nodoAux = buscar(n.nodoIzq, matricula);
		if (nodoAux == null) {
			return buscar(n.nodoDer, matricula);
		} else {
			return nodoAux;
		}
	}

	public NodoABB eliminar(String matricula) {
		return eliminar(matricula, this.raiz);
	}

	private NodoABB eliminar(String matricula, NodoABB a) {
		if (a == null)
			return a; // no existe x!!

		if (matricula.compareTo(a.getDato().getMatricula()) < 0)
			a.nodoIzq = eliminar(matricula, a.nodoIzq);
		else if (matricula.compareTo(a.getDato().getMatricula()) > 0)
			a.nodoDer = eliminar(matricula, a.nodoDer);
		else { // dato=x
			if (a.nodoIzq != null && a.nodoDer != null) {// tiene 2 sub-arboles
				a.getDato().matricula = Minimo(a.nodoDer).getDato().getMatricula();
				a.nodoDer = eliminarMin(a.nodoDer);
			} else
				a = (a.nodoIzq != null) ? a.nodoIzq : a.nodoDer;
		}
		return a;
	}

	// Eliminar el menor elemento del subárbol
	private NodoABB eliminarMin(NodoABB a) {
		if (a == null)
			return a;

		if (a.nodoIzq != null) {
			a.nodoIzq = eliminarMin(a.nodoIzq);
			return a;
		} else
			return a.nodoDer;
	}

	// retorna nodo del mínimo elemento
	private NodoABB Minimo(NodoABB nodo) {
		if (nodo != null)
			while (nodo.nodoIzq != null)
				nodo = nodo.nodoDer;
		return nodo;
	}

	// retorna nodo del máximo elemento
	private NodoABB Maximo(NodoABB nodo) {
		if (nodo != null)
			while (nodo.nodoDer != null)
				nodo = nodo.nodoDer;
		System.out.println(nodo.getDato().getMatricula());
		return nodo;
	}

}

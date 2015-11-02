package ort.aed2.ob20152;

public class ArbolABB {
	
	private NodoABB raiz;
	private int cantNodos;
	private int cantHojas;
	private int peso;
	private int altura;
	
	public ArbolABB() {
		this.raiz = null;
	}
	
	public ArbolABB(Movil movil) {
		this.raiz = new NodoABB();
		raiz.setDato(movil);
		this.cantHojas = 0;
	}
	
	public void insertar(Movil m) {
			NodoABB n = new NodoABB(m);
			if (this.raiz == null) {
				this.raiz = n;
			} else {
				insertar(n, this.raiz);
			}
		}

		// Precondition: n <> null
		private void insertar(NodoABB n, NodoABB raiz) {
			if (raiz.getDato().getMatricula().compareTo(n.getDato().getMatricula()) > 0) {
				if (n.nodoIzq == null) {
					n.nodoIzq = n;
				} else {
					insertar(n, n.nodoIzq);
				}
			} else {
				if (n.nodoDer == null) {
					n.nodoDer = n;
				} else {
					insertar(n, n.nodoDer);
				}
			}
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

		
		
		


}

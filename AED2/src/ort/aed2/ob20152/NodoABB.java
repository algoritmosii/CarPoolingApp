package ort.aed2.ob20152;

public class NodoABB {
	
	private Movil movil;
	public NodoABB nodoDer;
	public NodoABB nodoIzq;

	public NodoABB(Movil d) {
		this.movil = d;
	}

	public NodoABB() {
		// TODO Auto-generated constructor stub
	}

	public Movil getDato() {
		return movil;
	}

	public void setDato(Movil dato) {
		this.movil = dato;
	}


}

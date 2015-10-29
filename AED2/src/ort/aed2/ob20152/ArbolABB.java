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


}

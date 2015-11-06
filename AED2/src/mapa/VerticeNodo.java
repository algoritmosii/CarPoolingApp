package mapa;

public class VerticeNodo {

	private int dato;
	private int destino;
	private int peso;
	private VerticeNodo siguiente;
	private VerticeNodo anterior;

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public VerticeNodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(VerticeNodo siguiente) {
		this.siguiente = siguiente;
	}

	public VerticeNodo getAnterior() {
		return anterior;
	}

	public void setAnterior(VerticeNodo anterior) {
		this.anterior = anterior;
	}

	public VerticeNodo() {
		
	}
}

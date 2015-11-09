package mapa;

public class EsquinaNodo {

	private double coordX;
	private double coordY;
	private EsquinaNodo siguiente;
	private EsquinaNodo anterior;

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public EsquinaNodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(EsquinaNodo siguiente) {
		this.siguiente = siguiente;
	}

	public EsquinaNodo getAnterior() {
		return anterior;
	}

	public void setAnterior(EsquinaNodo anterior) {
		this.anterior = anterior;
	}

	public EsquinaNodo() {

	}
}

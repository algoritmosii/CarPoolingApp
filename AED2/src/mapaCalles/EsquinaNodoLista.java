package mapaCalles;

public class EsquinaNodoLista {

	private double coordX;
	private double coordY;
	private EsquinaNodoLista siguiente;
	private EsquinaNodoLista anterior;

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

	public EsquinaNodoLista getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(EsquinaNodoLista siguiente) {
		this.siguiente = siguiente;
	}

	public EsquinaNodoLista getAnterior() {
		return anterior;
	}

	public void setAnterior(EsquinaNodoLista anterior) {
		this.anterior = anterior;
	}

	public EsquinaNodoLista() {

	}
}

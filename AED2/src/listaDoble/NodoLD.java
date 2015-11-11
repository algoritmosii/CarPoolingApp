package listaDoble;

public class NodoLD {

	private String dato;
	private String color;
	private NodoLD siguiente;

	public NodoLD getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoLD siguiente) {
		this.siguiente = siguiente;
	}

	public String getElemento() {
		return dato;
	}

	public void setElemento(String elemento) {
		this.dato = elemento;
	}
	
	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public NodoLD(String valor) {
		this.dato = valor;
		this.siguiente = null;
		this.color = "blue";
	}
}

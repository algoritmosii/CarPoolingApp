package listaDoble;

public class NodoLD {

	private String dato;
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

	public NodoLD(String valor) {
		this.dato = valor;
		this.siguiente = null;
	}
}

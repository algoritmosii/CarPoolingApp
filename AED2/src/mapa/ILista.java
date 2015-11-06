package mapa;

public interface ILista {
	
	void insertarInicio(int destino, int peso);
	
	boolean esVacia();
	
	void imprimir();
	
	boolean existe(int valor);
	
	void borrarInicio();
	
	void borrar(int valor);
	
	void vaciarLista();

	VerticeNodo buscarElemento(int valor);
}

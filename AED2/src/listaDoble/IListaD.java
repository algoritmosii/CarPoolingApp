package listaDoble;

public interface IListaD {

	void insertarInicio(String valor);

	boolean esVacia();

	//void imprimir();

	boolean existe(String valor);

	void borrarInicio();

	void vaciarLista();

	NodoLD buscarElemento(String valor);

	int getCantNodos();

	void imprimir(int pos);

	void insertarInicio(String dato, String colorPin);
}

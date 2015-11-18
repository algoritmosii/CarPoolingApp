package mapaCalles;

public interface ILista {

	void insertarInicio(int destino, int peso);

	boolean esVacia();

	void imprimir();

	boolean existe(double x, double y);

	void borrarInicio();

	void vaciarLista();
}

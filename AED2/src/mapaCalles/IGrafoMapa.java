package mapaCalles;

public interface IGrafoMapa {

	public boolean crearGrafoVacio(int maxNodos);
	
	public void agregarVertice(int numero);

	public void agregarArista(int origen, int destino, int peso);
	
	//public void eliminarVertice(int numero);

	//public void eliminarArista(int origen, int destino);

	public boolean sonAdyacentes(int origen, int destino);

	public ListaEsquinas verticesAdyacentes(int vertice);
	
	//public boolean existeVertice(int v);

	//public boolean esConexo();
	
	public boolean destruirGrafo();

	boolean existeVertice(int v);

}

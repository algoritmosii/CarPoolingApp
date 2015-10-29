package ort.aed2.ob20152;

public interface IGrafo {

	public void crearGrafo(int cantMax);
	
	public void agregarVertice(int numero);
	
	public void agregarArista(int origen, int destino);
	
	public boolean esAdyacente(int origen, int destino);
	
	public ListaInt listaAdyacentes(int vertice);
	
	public boolean esConexo();
}

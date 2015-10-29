package ort.aed2.ob20152;

// Interfaz del sistema
// No modificar esta clase!!!!!!!!!
public interface ISistema {

	Retorno inicializarSistema (int cantPuntos);
	
	Retorno destruirSistema();
	
	Retorno registrarMovil(String matricula, String conductor);
	
	Retorno deshabilitarMovil(String matricula);
	
	Retorno eliminarMovil(String matricula);
	
	Retorno habilitarMovil(String matricula);
	
	Retorno asignarUbicacionMovil(String matricula, Double coordX, Double coordY);
	
	Retorno buscarMovil(String matricula);
	
	Retorno informeMoviles();
	
	Retorno registrarEsquina(Double coordX, Double coordY);
	
	Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros);
	
	Retorno eliminarEsquina(Double coordX, Double coordY);
	
	Retorno eliminarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf);
	
	Retorno movilMasCercano(Double coordX, Double coordY);
	
	Retorno verMovilesEnRadio(Double coordX, Double coordY, int radio);
	
	Retorno verMapa();
	

	
}
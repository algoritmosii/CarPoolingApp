package ort.aed2.ob20152;


public class Sistema implements ISistema {

	public Retorno inicializarSistema (int cantPuntos) {
		// TODO: reemplazar por su implementacion
		return new Retorno();
	}
	
	public Retorno destruirSistema() {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno registrarMovil(String matricula, String conductor) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno deshabilitarMovil(String matricula) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno eliminarMovil(String matricula) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno habilitarMovil(String matricula) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno asignarUbicacionMovil(String matricula, Double coordX, Double coordY) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno buscarMovil(String matricula) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno informeMoviles() {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno registrarEsquina(Double coordX, Double coordY) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno eliminarEsquina(Double coordX, Double coordY) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno movilMasCercano(Double coordX, Double coordY) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno verMovilesEnRadio(Double coordX, Double coordY, int radio) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno verMapa() {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	

	
}

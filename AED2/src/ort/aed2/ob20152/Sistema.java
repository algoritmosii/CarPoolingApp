package ort.aed2.ob20152;

import mapa.Mapa;
import ort.aed2.ob20152.Enumerados.estadoMovil;

public class Sistema implements ISistema {

	Mapa mapa;
	ArbolABB abb = new ArbolABB();

	public Retorno inicializarSistema(int cantPuntos) {
		Retorno r = new Retorno();
		mapa = new Mapa();
		if (cantPuntos <= 0) {
			r.resultado = Retorno.Resultado.ERROR_1;
		} else if (mapa.crearGrafoVacio(cantPuntos))
			r.resultado = Retorno.Resultado.OK;
		return r;
	}

	public Retorno destruirSistema() {
		Retorno r = new Retorno();
		if (mapa.destruirGrafo())
			r.resultado = Retorno.Resultado.OK;
		return r;
	}

	@Override
	public Retorno registrarMovil(String matricula, String conductor) {
		Retorno r = new Retorno();
		Enumerados.estadoMovil estado = estadoMovil.DISPONIBLE;

		if (abb.buscar(matricula) != null) {
			r.resultado = Retorno.Resultado.ERROR_1;
			r.valorString = "Ya existe un móvil con la misma matrícula.";
			return r;
		}
		// Creo el movil
		Movil m = new Movil(matricula, conductor, estado);

		abb.insertar(m);
		r.resultado = Retorno.Resultado.OK;
		return r;
	}

	@Override
	public Retorno deshabilitarMovil(String mat) {
		NodoABB m = abb.buscar(mat);

		Retorno r = new Retorno();
		if (m.getDato().estado.equals(Enumerados.estadoMovil.DISPONIBLE)) {
			m.getDato().estado = Enumerados.estadoMovil.DESHABILITADO;
			r.resultado = r.resultado.OK;
		} else {
			if (m.getDato().estado.equals(Enumerados.estadoMovil.DESHABILITADO)
					|| m.getDato().estado
							.equals(Enumerados.estadoMovil.ASGINADO)) {
				r.resultado = r.resultado.ERROR_2;
			}
		}
		return r;
	}

	@Override
	public Retorno eliminarMovil(String matricula) {
		
		NodoABB m = abb.buscar(matricula); 
		Retorno r = new Retorno();
		
		if (abb.buscar(matricula) != null) {	
			if (m.getDato().estado.equals(Enumerados.estadoMovil.ASGINADO)) {
				r.resultado = Retorno.Resultado.ERROR_1;
				r.valorString = "El móvil está asignado, por lo tanto no se puede eliminar.";
				return r;
			}
			
			abb.eliminar(matricula);
			r.resultado = Retorno.Resultado.OK;
			return r;
		} 
		
		r.resultado = Retorno.Resultado.ERROR_1;
		r.valorString = "No existe el móvil pasado como parámetro.";
		
		return r;
	}

	@Override
	public Retorno habilitarMovil(String matricula) {
		NodoABB m = abb.buscar(matricula);

		Retorno r = new Retorno();
		if (m.getDato().estado.equals(Enumerados.estadoMovil.DESHABILITADO)) {
			m.getDato().estado = Enumerados.estadoMovil.DISPONIBLE;
			r.resultado = r.resultado.OK;
			r.valorString = "El móvil fué habilitado con éxito.";
		} else {
			if (m.getDato().estado.equals(Enumerados.estadoMovil.DISPONIBLE)
					|| m.getDato().estado
							.equals(Enumerados.estadoMovil.ASGINADO)) {
				r.resultado = r.resultado.ERROR_2;
				r.valorString = "El móvil ya estaba disponible o asignado.";
			}
		}
		return r;
	}

	@Override
	public Retorno asignarUbicacionMovil(String matricula, Double coordX,
			Double coordY) {
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
		Retorno r = new Retorno();
		
		abb.mostrar();
		
		r.resultado = r.resultado.OK;
		return r;
	}

	@Override
	public Retorno registrarEsquina(Double coordX, Double coordY) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf, int metros) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno eliminarEsquina(Double coordX, Double coordY) {
		// TODO reemplazar por su implementacion
		return new Retorno();
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf) {
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

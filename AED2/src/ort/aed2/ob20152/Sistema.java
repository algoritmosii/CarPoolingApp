package ort.aed2.ob20152;

import mapaCalles.EsquinaNodoHash;
import mapaCalles.MapaGrafo;
import ort.aed2.ob20152.Enumerados.estadoMovil;

public class Sistema implements ISistema {

	MapaGrafo mapa;
	ArbolABB abb = new ArbolABB();

	public Retorno inicializarSistema(int cantPuntos) {
		Retorno r = new Retorno();
		this.mapa = new MapaGrafo();
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
			r.valorString = "Ya existe un mï¿½vil con la misma matrï¿½cula.";
			return r;
		}
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
					|| m.getDato().estado.equals(Enumerados.estadoMovil.ASGINADO)) {
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
				r.valorString = "El mï¿½vil estï¿½ asignado, por lo tanto no se puede eliminar.";
				return r;
			}
			abb.eliminar(matricula);
			r.resultado = Retorno.Resultado.OK;
			return r;
		}
		r.resultado = Retorno.Resultado.ERROR_1;
		r.valorString = "No existe el mï¿½vil pasado como parï¿½metro.";

		return r;
	}

	@Override
	public Retorno habilitarMovil(String matricula) {
		NodoABB m = abb.buscar(matricula);

		Retorno r = new Retorno();
		if (m.getDato().estado.equals(Enumerados.estadoMovil.DESHABILITADO)) {
			m.getDato().estado = Enumerados.estadoMovil.DISPONIBLE;
			r.resultado = r.resultado.OK;
			r.valorString = "El mï¿½vil fuï¿½ habilitado con ï¿½xito.";
		} else {
			if (m.getDato().estado.equals(Enumerados.estadoMovil.DISPONIBLE)
					|| m.getDato().estado.equals(Enumerados.estadoMovil.ASGINADO)) {
				r.resultado = r.resultado.ERROR_2;
				r.valorString = "El mï¿½vil ya estaba disponible o asignado.";
			}
		}
		return r;
	}

	@Override
	public Retorno asignarUbicacionMovil(String matricula, Double coordX, Double coordY) {
		Retorno r = new Retorno();
		if (coordenadasValidas(coordX, coordY)) {
			if (!mapa.esquinas.existeEsquina(coordX, coordY)) {
				r.resultado = Retorno.Resultado.ERROR_1;
				r.valorString = "Coordenadas no existen.";
				return r;
			} else if (this.mapa.existeUnMovil(coordX, coordY)) {
				r.resultado = Retorno.Resultado.ERROR_2;
				return r;
			}
			if (abb.buscar(matricula) == null) {
				r.resultado = Retorno.Resultado.ERROR_3;
				r.valorString = "El movil no existe en el sistema";
				return r;
			}
			if (this.mapa.asignarUbicacion(matricula, coordX, coordY)) {
				estadoMovil estado = estadoMovil.ASGINADO;
				abb.buscar(matricula).setEstado(estado);
				r.resultado = Retorno.Resultado.OK;
				return r;
			}
		} else {
			r.resultado = Retorno.Resultado.ERROR_1;
			r.valorString = "Coordenadas no existen.";
		}
		return r;
	}

	@Override
	public Retorno buscarMovil(String matricula) {
		Retorno r = new Retorno();
		String x = "";
		String y = "";
		NodoABB nodo = abb.buscar(matricula);
		if (nodo != null) {
			EsquinaNodoHash[] l = mapa.esquinas.esquinas;
			for (int i=0;i< l.length;i++){
				if (l[i].getMatriculaMovil().equals(matricula)) {
					x = l[i].getX().toString();
					y = l[i].getY().toString();
					
					System.out.println(nodo.getDato().getMatricula() + ";" + nodo.getDato().getNombreConductor() + ";" + nodo.getDato().getEstado().toString() + ";" + x + ";" + y);
					r.resultado = Retorno.Resultado.OK;
					
				}
			}					
			
		} else {
		
			r.resultado = Retorno.Resultado.ERROR_1;
			r.valorString = "El movil no pudo ser encontrado";
			
		}
		return r;
	}

	@Override
	public Retorno informeMoviles() {
		Retorno r = new Retorno();

		abb.mostrar();

		r.resultado = r.resultado.OK;
		return r;
	}

	/*
	 * PRE: el largo coordX y coordY debe ser como maximo 11 caracteres y como
	 * minimo 8 caracteres
	 */
	@Override
	public Retorno registrarEsquina(Double coordX, Double coordY) {
		Retorno r = new Retorno();
		if (coordenadasValidas(coordX, coordY)) {
			r = mapa.registrarEsquina(coordX, coordY);
		}
		return r;
	}

	private boolean coordenadasValidas(Double coordX, Double coordY) {
		if (coordX != null && coordY != null) {
			String auxX = String.valueOf(coordX);
			String auxY = String.valueOf(coordX);
			int charsX = auxX.length();
			int charsY = auxY.length();
			if (charsX > 7 && charsX < 12) {
				if (charsY > 7 && charsY < 12) {
					return true;
				}
			}
		}
		return false;
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
		// TODO filtrar mobiles en mapa por moviles disponibles(verde),
		// deshabilitados(rojo), asignados(amarillo)
		Retorno r = new Retorno();
		this.mapa.levantarMapaEnBrowser(abb);
		r.resultado = Retorno.Resultado.OK;
		return r;
	}
}

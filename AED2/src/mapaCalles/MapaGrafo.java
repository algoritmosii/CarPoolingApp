package mapaCalles;

import java.awt.Desktop;
import java.net.URL;

import ort.aed2.ob20152.ArbolABB;
import ort.aed2.ob20152.Retorno;

import utils.URLMapa;

public class MapaGrafo implements IGrafoMapa {

	private int size;
	private int cantMaxNodos;
	private ListaEsquinas[] verticesAdyacentes;
	private boolean[] nodosUsados;
	public MapaHashCerrado esquinas;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCantNodos() {
		return cantMaxNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantMaxNodos = cantNodos;
	}

	@Override
	public boolean crearGrafoVacio(int maxNodos) {
		this.size = 0;
		this.cantMaxNodos = maxNodos;

		this.verticesAdyacentes = new ListaEsquinas[this.cantMaxNodos + 1];
		try {
			for (int i = 0; i < this.cantMaxNodos; i++) {
				this.verticesAdyacentes[i] = new ListaEsquinas();
			}
			this.esquinas = new MapaHashCerrado(maxNodos);
			this.nodosUsados = new boolean[this.cantMaxNodos + 1];
			return true;
		} catch (Exception e) {
			// "Log: Error - crearGrafoVacio:" + e.toString();
		}
		return false;
	}

	@Override
	public boolean destruirGrafo() {
		try {
			this.verticesAdyacentes = new ListaEsquinas[0];
			this.nodosUsados = new boolean[0];
			int cantVert = verticesAdyacentes.length;
			for (int i = 0; i < cantVert; i++) {
				this.verticesAdyacentes[i] = new ListaEsquinas();
			}

			if (this.verticesAdyacentes.length == 0) {
				if (this.nodosUsados.length == 0) {
					this.cantMaxNodos = 0;
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println("Log: Error - destruirGrafo:" + e.toString());
		}
		return false;
	}

	@Override
	public void agregarArista(int origen, int destino, int peso) {
		this.verticesAdyacentes[origen].insertarInicio(destino, peso);
	}

	public Retorno registrarEsquina(Double coordX, Double coordY) {
		Retorno r = new Retorno();

		r = esquinas.insertar(coordX, coordY, this.cantMaxNodos);
		if (r.resultado.equals(Retorno.Resultado.OK)) {
			size++;
		}
		return r;
	}

	@Override
	public void agregarVertice(int v) {
		this.nodosUsados[v] = true;
		this.size++;
	}

	public boolean esVacio() {
		return this.size == 0;
	}

	@Override
	public ListaEsquinas verticesAdyacentes(int v) {
		return this.verticesAdyacentes[v];
	}

	@Override
	public boolean existeVertice(int v) {
		return this.nodosUsados[v];
	}

	@Override
	public boolean sonAdyacentes(int origen, int destino) {
		// TODO Auto-generated method stub
		return false;
	}

	public void levantarMapaEnBrowser(ArbolABB abb) {
		URLMapa url = new URLMapa();
		try {

			esquinas.levantarMapaEnBrowser(abb);
		
		} catch (Exception ex) {
			System.out.println(" Error en levantarMapaEnBrowser.. " + ex.toString());
			ex.printStackTrace();
		}
	}

	public void levantarMapa(String url) {
		try {
			Desktop.getDesktop().browse(new URL(url).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public boolean existeEsquina(Double coordX, Double coordY) { if
	 * (this.esquinas.existeEsquinaXY(coordX, coordY)) { return true; } return
	 * false; }
	 */
	public boolean existeEsquina(Double coordX, Double coordY) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existeUnMovil(Double coordX, Double coordY) {
		if (this.esquinas.existeUnMovilEnXY(coordX, coordY)) {
			return true;
		}
		return false;
	}

	public boolean asignarUbicacion(String matricula, Double coordX, Double coordY) {
		if (this.esquinas.asignarUbicacionAMovil(coordX, coordY, matricula)) {
			return true;
		}
		return false;
	}

}

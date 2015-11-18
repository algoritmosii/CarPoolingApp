package mapaCalles;

import utils.URLMapa;

import java.awt.Desktop;
import java.net.URL;

import listaDoble.Lista;
import ort.aed2.ob20152.ArbolABB;
import ort.aed2.ob20152.Enumerados;
import ort.aed2.ob20152.NodoABB;
import ort.aed2.ob20152.Retorno;

public class MapaHashCerrado {

	int capacidadHabilitada;

	int capacidadHash;

	int nodosUsados;

	public EsquinaNodoHash[] esquinas;

	public MapaHashCerrado(int capacidad) {

		this.capacidadHabilitada = capacidad;

		this.capacidadHash = verificarPrimo(capacidad);

		this.nodosUsados = 0;

		this.esquinas = new EsquinaNodoHash[capacidadHash];

		for (int i = 0; i < capacidadHash; i++) {
			esquinas[i] = new EsquinaNodoHash("");
		}
	}

	public Retorno insertar(Double coordX, Double coordY, int cantNodos) {
		Retorno r = new Retorno();
		String coordenadas = coordX + "*" + coordY;

		if (cantNodos > nodosUsados) {

			EsquinaNodoHash esquina = new EsquinaNodoHash(coordenadas);
			esquina.setCoordenadas(coordenadas);
			esquina.setCoordenadas(coordX, coordY);

			r = insertar(esquina);
			if (r.resultado.equals(Retorno.Resultado.OK)) {
				this.nodosUsados++;
			}
		} else {
			r.resultado = Retorno.Resultado.ERROR_1;
		}
		return r;
	}

	public Retorno insertar(EsquinaNodoHash esquina) {
		Retorno r = new Retorno();
		int x = 1;
		int llave = getLlave(esquina.getX(), esquina.getY());

		int pos = h(llave, x);
		boolean noInsertoTodavia = true;

		if (capacidadHabilitada > 0) {
			if (!existeEsquina(esquina.getX(), esquina.getY())) {
				while (noInsertoTodavia) {

					pos = h(llave, x);

					if (esquinas[pos].getCoordenadas().equals("")) {
						System.out.println("posicion libre en clave " + pos);
						esquinas[pos].setCoordenadas(esquina.getCoordenadas());
						esquinas[pos].setClave(pos);
						esquina.setClave(pos);
						noInsertoTodavia = false;
						capacidadHabilitada--;
						r.resultado = Retorno.Resultado.OK;
						return r;
					} else {
						x++;
						System.out.println("Todavia no encontre un lugar libre para insertar una nueva cedula");
					}
				}
			} else {
				r.resultado = Retorno.Resultado.ERROR_2;
			}
		}
		return r;
	}

	private int h(int llave, int x) {

		return (x + llave) % this.capacidadHash;

	}

	private int verificarPrimo(int maxNodos) {
		int testPrimo = maxNodos;
		if (testPrimo % 2 == 0) {
			testPrimo = maxNodos + 1;
		}
		return testPrimo;
	}

	public boolean existeEsquina(Double x, Double y) {
		String coordenadas = x + "*" + y;
		int c = esquinas.length;
		boolean altRes = false;
		for (int i = 0; i < c; i++) {
			if (esquinas[i].getCoordenadas().equals(coordenadas)) {
				altRes = true;
				return altRes;
			}
		}
		return altRes;
	}

	public boolean pertenece(Integer llave, String coordenadas, int x) {
		int pos = h(llave, x);
		return esquinas[pos].getCoordenadas().equals(coordenadas);
	}

	private Integer getLlave(Double coordX, Double coordY) {
		String r;
		Integer salida;
		String auxX = String.valueOf(coordX);
		auxX = auxX.replace("*", "");
		auxX = auxX.replace(".", "");
		auxX = auxX.replace("-", "");
		auxX = auxX.substring(4, 8);

		String auxY = String.valueOf(coordY);
		auxY = auxY.replace("*", "");
		auxY = auxY.replace(".", "");
		auxY = auxY.replace("-", "");
		auxY = auxY.substring(4, 8);

		r = auxX + "" + auxY;
		salida = Integer.parseInt(r.trim());
		return salida;
	}

	public Lista nodos() {

		Lista nodos = new Lista();

		int len = esquinas.length;
		for (int x = 0; x < len; x++) {
			String coordenadas = esquinas[x].getCoordenadas();
			String colorPin = esquinas[x].getColorPinMapa();
			nodos.insertarInicio(coordenadas, colorPin);
			System.out.println(" ELEMENTO: " + coordenadas);
		}

		return nodos;
	}

	public boolean existeUnMovilEnXY(Double coordX, Double coordY) {
		int llave = getLlave(coordX, coordY);
		String coordenadas = coordX + "*" + coordY;
		// hacer otro pertenece y chequear que la matricula no sea null

		/*
		 * if (existeMovil(llave, coordenadas)) { return true; }
		 */
		return false;
	}

	public boolean asignarUbicacionAMovil(Double coordX, Double coordY, String matricula) {
		int llave = getLlave(coordX, coordY);
		String coordenadas = coordX + "*" + coordY;
		int tam = esquinas.length;
		for (int i = 0; i < tam; i++) {
			if (this.esquinas[i].getCoordenadas().equals(coordenadas)) {
				this.esquinas[i].setMatriculaMovil(matricula);
				this.esquinas[i].setColorPinMapa("yellow");
				if (esquinas[i].getMatriculaMovil().equals(matricula)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean estaLLeno() {
		int c = esquinas.length;
		boolean altRes = false;
		for (int i = 0; i < c; i++) {
			if (esquinas[i].getCoordenadas().equals("")) {
				altRes = false;
				return altRes;
			} else {
				altRes = true;
			}
		}
		System.out.println("esta LLENO");
		return altRes;
	}

	public void levantarMapaEnBrowser(ArbolABB abb) {
		URLMapa url = new URLMapa();
		try {
			for (int i = 0; i < esquinas.length; i++) {
				if (esquinas[i].getMatriculaMovil() != null) {
					if (!esquinas[i].getMatriculaMovil().equals("")) {

						NodoABB n = abb.buscar(esquinas[i].getMatriculaMovil());

						Enumerados.estadoMovil estado = n.getDato().getEstado();
						
						if (estado.equals(Enumerados.estadoMovil.DISPONIBLE)) {
							esquinas[i].setColorPinMapa("green");
						} else if (estado.equals(Enumerados.estadoMovil.ASGINADO)) {
							esquinas[i].setColorPinMapa("yellow");
						} else if (estado.equals(Enumerados.estadoMovil.DESHABILITADO)) {
							esquinas[i].setColorPinMapa("red");
						}
					}
				}
			}
			url.append(esquinas);
			levantarMapa(url.getUrl());

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

}

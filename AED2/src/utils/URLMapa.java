package utils;

import listaDoble.NodoLD;

public class URLMapa {

	private String x;
	private String y;
	private static final String urlGoogleAPIs = "http://maps.googleapis.com/maps/api/staticmap?center=Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap";
	private static final String colorMarkers = "&markers=color:";
	private static final String label = "%7Clabel:1%7C";
	private static final String sensorFalse = "&sensor=false";
	private String colorPin;
	private String url;

	public URLMapa() {

	}	

	public String getColorPin() {
		return colorPin;
	}

	public void setColorPin(String colorPin) {
		this.colorPin = colorPin;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void append(NodoLD[] nodos) {
		try {
			int cant = nodos.length;
			String[] x_y = new String[3];
			StringBuilder urlBuilder = new StringBuilder();
			String puntoDelMapa = null;
			urlBuilder.append(urlGoogleAPIs);

			for (int i = 0; i < cant; i++) {
				String elemento = nodos[i].getElemento();
				if (!elemento.equals("")) {
					System.out.println("");

					x_y = elemento.split("\\*");
					this.x = x_y[0].substring(0, 6);
					this.y = x_y[1].substring(0, 6);
					this.colorPin = nodos[i].getColor();

					if (!this.x.equals("") && !this.y.equals("")
							&& !this.colorPin.equals("")) {
						puntoDelMapa = colorMarkers + this.colorPin + label
								+ this.x + "," + this.y;
						urlBuilder.append(puntoDelMapa);
					}
				}
			}
			urlBuilder.append(sensorFalse);
			this.url = urlBuilder.toString();
		} catch (Exception e) {
			System.out.println("error en append de URL " + e.toString()
					+ " trace: ");
			e.printStackTrace();
		}
	}
}

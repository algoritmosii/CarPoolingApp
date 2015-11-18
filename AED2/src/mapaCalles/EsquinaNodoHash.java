package mapaCalles;

public class EsquinaNodoHash {
	
	private String coordenadas;
	private String colorPinMapa;
	private String matriculaMovil;
	private int clave;
	private Double x;
	private Double y;

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coords) {
		this.coordenadas = coords;
	}
	
	public String getMatriculaMovil() {
		return matriculaMovil;
	}

	public void setMatriculaMovil(String matricula) {
		this.matriculaMovil = matricula;
	}	

	public String getColorPinMapa() {
		return colorPinMapa;
	}

	public void setColorPinMapa(String colorPinMapa) {
		this.colorPinMapa = colorPinMapa;
	}
	
	public int getClave() {
		return clave;
	}

	public void setClave(int c) {
		this.clave = c;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
	
	public void setCoordenadas(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public EsquinaNodoHash(String coordenadas) {
		this.coordenadas = coordenadas;
		this.colorPinMapa = "blue";
		this.setMatriculaMovil("");
		this.clave = -1;
	}
}

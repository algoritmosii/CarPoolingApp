package ort.aed2.ob20152;

public class Movil {
	
	public String matricula;
	public String nombreConductor;
			
	public Movil(String matricula, String nombreConductor) {
		super();
		this.matricula = matricula;
		this.nombreConductor = nombreConductor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombreConductor() {
		return nombreConductor;
	}

	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}

	public Enumerados estado;

	@Override
	public String toString() {
		return "Movil [matricula=" + matricula + ", nombreConductor=" + nombreConductor + ", estado=" + estado + "]";
	}
	
	

}

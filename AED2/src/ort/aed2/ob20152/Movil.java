package ort.aed2.ob20152;

public class Movil {
	
	public String matricula;
	public String nombreConductor;
	public Enumerados estado;
			
	public Movil(String matricula, String nombreConductor, Enumerados estado) {
		super();
		this.matricula = matricula;
		this.nombreConductor = nombreConductor;
		this.estado = estado;
	}

	public Enumerados getEstado() {
		return estado;
	}

	public void setEstado(Enumerados estado) {
		this.estado = estado;
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

	@Override
	public String toString() {
		return "Movil [matricula=" + matricula + ", nombreConductor=" + nombreConductor + ", estado=" + estado + "]";
	}
	
	

}

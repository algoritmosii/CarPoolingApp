package ort.aed2.ob20152;

public class Movil {
	
	public String matricula;
	public String nombreConductor;
	public Enumerados.estadoMovil estado;
			
	public Enumerados.estadoMovil getEstado() {
		return estado;
	}

	public void setEstado(Enumerados.estadoMovil estado) {
		this.estado = estado;
	}

	public Movil(String matricula, String nombreConductor, Enumerados.estadoMovil estadoMovil) {
		super();
		this.matricula = matricula;
		this.nombreConductor = nombreConductor;
		this.estado = estadoMovil;
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
		return "Movil [matricula=" + matricula + ", nombreConductor=" + 

nombreConductor + ", estado=" + estado + "]";
	}
	
	

}

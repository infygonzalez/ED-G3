package Reto2Modelo;

public class Aeropuerto {
	private String CodigoAeropuerto;
	private String NombreAeropuerto;
	public String getCodigoAeropuerto() {
		return CodigoAeropuerto;
	}
	public void setCodigoAeropuerto(String codigoAeropuerto) {
		CodigoAeropuerto = codigoAeropuerto;
	}
	public String getNombreAeropuerto() {
		return NombreAeropuerto;
	}
	public void setNombreAeropuerto(String nombreAeropuerto) {
		NombreAeropuerto = nombreAeropuerto;
	}
	@Override
	public String toString() {
		return "Aeropuerto [CodigoAeropuerto=" + CodigoAeropuerto + ", NombreAeropuerto=" + NombreAeropuerto + "]";
	}
	
	

}

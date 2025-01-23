package Reto2Modelo;

public class Otros {

	private String Fecha;
	private String Descripcion;

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Otros [Fecha=" + Fecha + ", Descripcion=" + Descripcion + "]";
	}
}

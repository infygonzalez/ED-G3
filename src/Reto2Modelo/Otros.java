package Reto2Modelo;

public class Otros extends Evento {

	private String Fecha;
	private String Descripcion;
	

	public Otros(String eventoID, String nombreEvento, String precio, Reto2Modelo.Viaje viaje, String fecha,
			String descripcion) {
		super(eventoID, nombreEvento, precio, viaje);
		Fecha = fecha;
		Descripcion = descripcion;
	}

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
		return  super.toString()+"Otros [Fecha=" + Fecha + ", Descripcion=" + Descripcion + "]";
	}
}

package Reto2Modelo;

public class Evento {
 
	private String EventoID;
	private String NombreEvento;
	private String Precio;
	private Viaje Viaje;
	

	public Evento(String eventoID, String nombreEvento, String precio,Viaje viaje) {
		EventoID = eventoID;
		NombreEvento = nombreEvento;
		Precio = precio;
		Viaje = viaje;
	}
	public String getEventoID() {
		return EventoID;
	}
	public void setEventoID(String eventoID) {
		EventoID = eventoID;
	}
	public String getNombreEvento() {
		return NombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		NombreEvento = nombreEvento;
	}
	public String getPrecio() {
		return Precio;
	}
	public void setPrecio(String precio) {
		Precio = precio;
	}
	public Viaje getViaje() {
		return Viaje;
	}
	public void setViaje(Viaje viaje) {
		Viaje = viaje;
	}
	@Override
	public String toString() {
		return "Evento [EventoID=" + EventoID + ", NombreEvento=" + NombreEvento + ", Precio=" + Precio + ", Viaje="
				+ Viaje + "]";
	}

}

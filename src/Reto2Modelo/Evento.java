package Reto2Modelo;

public class Evento {
 
	private String EventoID;
	private String NombreEvento;
	private String Precio;
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
	@Override
	public String toString() {
		return "Evento [EventoID=" + EventoID + ", NombreEvento=" + NombreEvento + ", Precio=" + Precio + "]";
	}
	
}

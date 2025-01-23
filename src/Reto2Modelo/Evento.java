package Reto2Modelo;

public class Evento {
 
	private String EventoID;
	private String NombreEvento;
	private String Precio;
	private Viaje ViajeID;
	

	
	public Evento(String eventoID, String nombreEvento, String precio, Viaje viajeID) {
		super();
		EventoID = eventoID;
		NombreEvento = nombreEvento;
		Precio = precio;
		ViajeID = viajeID;
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
	public Viaje getViajeID() {
		return ViajeID;
	}
	public void setViajeID(Viaje viajeID) {
		ViajeID = viajeID;
	}
	@Override
	public String toString() {
		return "Evento [EventoID=" + EventoID + ", NombreEvento=" + NombreEvento + ", Precio=" + Precio + ", ViajeID="
				+ ViajeID + "]";
	}


}

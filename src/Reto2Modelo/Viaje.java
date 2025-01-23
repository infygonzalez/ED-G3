package Reto2Modelo;

import java.util.ArrayList;

public class Viaje {
	 private String ViajeID;
	 private String NombreViaje;
	 private String Descripción; 
	 private String TipoViaje;
	 private String FechaInicio;
	 private String FechaFin;
	 private String DuracionViaje;
	 private String ServiciosNoIncluidos;
	 private String PaisDestino;
	 private ArrayList<Evento> Eventos;
	 
	public Viaje(String viajeID, String nombreViaje, String descripción, String tipoViaje, String fechaInicio,
			String fechaFin, String duracionViaje, String serviciosNoIncluidos, String paisDestino,
			ArrayList<Evento> eventos) {
		super();
		ViajeID = viajeID;
		NombreViaje = nombreViaje;
		Descripción = descripción;
		TipoViaje = tipoViaje;
		FechaInicio = fechaInicio;
		FechaFin = fechaFin;
		DuracionViaje = duracionViaje;
		ServiciosNoIncluidos = serviciosNoIncluidos;
		PaisDestino = paisDestino;
		Eventos = eventos;
	}
	public String getViajeID() {
		return ViajeID;
	}
	public String getTipoViaje() {
		return TipoViaje;
	}
	public void setTipoViaje(String tipoViaje) {
		TipoViaje = tipoViaje;
	}
	public ArrayList<Evento> getEventos() {
		return Eventos;
	}
	public void setEventos(ArrayList<Evento> eventos) {
		Eventos = eventos;
	}
	public void setViajeID(String viajeID) {
		ViajeID = viajeID;
	}
	public String getNombreViaje() {
		return NombreViaje;
	}
	public void setNombreViaje(String nombreViaje) {
		NombreViaje = nombreViaje;
	}
	public String getDescripción() {
		return Descripción;
	}
	public void setDescripción(String descripción) {
		Descripción = descripción;
	}
	public String getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}
	public String getDuracionViaje() {
		return DuracionViaje;
	}
	public void setDuracionViaje(String duracionViaje) {
		DuracionViaje = duracionViaje;
	}
	public String getServiciosNoIncluidos() {
		return ServiciosNoIncluidos;
	}
	public void setServiciosNoIncluidos(String serviciosNoIncluidos) {
		ServiciosNoIncluidos = serviciosNoIncluidos;
	}
	public String getPaisDestino() {
		return PaisDestino;
	}
	public void setPaisDestino(String paisDestino) {
		PaisDestino = paisDestino;
	}
	@Override
	public String toString() {
		return "Viaje [ViajeID=" + ViajeID + ", NombreViaje=" + NombreViaje + ", Descripción=" + Descripción
				+ ", TipoViaje=" + TipoViaje + ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin
				+ ", DuracionViaje=" + DuracionViaje + ", ServiciosNoIncluidos=" + ServiciosNoIncluidos
				+ ", PaisDestino=" + PaisDestino + ", Eventos=" + Eventos + "]";
	}

	 

}

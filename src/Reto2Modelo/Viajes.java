package Reto2Modelo;

public class Viajes {
	 private String ViajeID;
	 private String NombreViaje;
	 private String Descripción; 
	 private String vTipoViaje;
	 private String FechaInicio;
	 private String FechaFin;
	 private String DuracionViaje;
	 private String ServiciosNoIncluidos;
	 private String PaisDestino;
	public String getViajeID() {
		return ViajeID;
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
	public String getvTipoViaje() {
		return vTipoViaje;
	}
	public void setvTipoViaje(String vTipoViaje) {
		this.vTipoViaje = vTipoViaje;
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
		return "Viajes [ViajeID=" + ViajeID + ", NombreViaje=" + NombreViaje + ", Descripción=" + Descripción
				+ ", vTipoViaje=" + vTipoViaje + ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin
				+ ", DuracionViaje=" + DuracionViaje + ", ServiciosNoIncluidos=" + ServiciosNoIncluidos
				+ ", PaisDestino=" + PaisDestino + "]";
	}
	 

}

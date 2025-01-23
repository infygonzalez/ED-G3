package Reto2Modelo;

public class VueloIda extends Evento {

	private String CodigoVuelo;
	private String FechaSalida;
	private String HoraSalida;
	private String DuracionVuelo;
	private Aeropuerto AeropuertoOrigen;
	private Aeropuerto AeropuertoDestino;


	public VueloIda(String eventoID, String nombreEvento, String precio, Reto2Modelo.Viaje viaje, String codigoVuelo,
			String fechaSalida, String horaSalida, String duracionVuelo, Aeropuerto aeropuertoOrigen,
			Aeropuerto aeropuertoDestino) {
		super(eventoID, nombreEvento, precio, viaje);
		CodigoVuelo = codigoVuelo;
		FechaSalida = fechaSalida;
		HoraSalida = horaSalida;
		DuracionVuelo = duracionVuelo;
		AeropuertoOrigen = aeropuertoOrigen;
		AeropuertoDestino = aeropuertoDestino;
	}
	public Aeropuerto getAeropuertoOrigen() {
		return AeropuertoOrigen;
	}
	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		AeropuertoOrigen = aeropuertoOrigen;
	}
	public Aeropuerto getAeropuertoDestino() {
		return AeropuertoDestino;
	}
	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		AeropuertoDestino = aeropuertoDestino;
	}
	public String getCodigoVuelo() {
		return CodigoVuelo;
	}
	public void setCodigoVuelo(String codigoVuelo) {
		CodigoVuelo = codigoVuelo;
	}
	public String getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public String getHoraSalida() {
		return HoraSalida;
	}
	public void setHoraSalida(String horaSalida) {
		HoraSalida = horaSalida;
	}
	public String getDuracionVuelo() {
		return DuracionVuelo;
	}
	public void setDuracionVuelo(String duracionVuelo) {
		DuracionVuelo = duracionVuelo;
	}
	
	@Override
	public String toString() {
		return super.toString()+"VueloIda [CodigoVuelo=" + CodigoVuelo + ", FechaSalida=" + FechaSalida + ", HoraSalida=" + HoraSalida
				+ ", DuracionVuelo=" + DuracionVuelo + ", AeropuertoOrigen=" + AeropuertoOrigen + ", AeropuertoDestino="
				+ AeropuertoDestino + "]";
	}
	
	
	
	}
	
	
	




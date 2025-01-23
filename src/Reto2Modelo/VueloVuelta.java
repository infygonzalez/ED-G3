package Reto2Modelo;

public class VueloVuelta extends VueloIda {
	
	private String CodigoVueloVuelta;
	private String FechaSalidaVuelta;
	private String HoraSalidaVuelta;
	private String DuraciónVueloVuelta;
	private Aeropuerto AeropuertoOrigenVuelta;
	private Aeropuerto AeropuertoDestinoVuelta;

	
	public VueloVuelta(String eventoID, String nombreEvento, String precio, Viaje viaje, String codigoVuelo,
			String fechaSalida, String horaSalida, String duracionVuelo, Aeropuerto aeropuertoOrigen,
			Aeropuerto aeropuertoDestino, String codigoVueloVuelta, String fechaSalidaVuelta, String horaSalidaVuelta,
			String duraciónVueloVuelta, Aeropuerto aeropuertoOrigenVuelta, Aeropuerto aeropuertoDestinoVuelta) {
		super(eventoID, nombreEvento, precio, viaje, codigoVuelo, fechaSalida, horaSalida, duracionVuelo,
				aeropuertoOrigen, aeropuertoDestino);
		CodigoVueloVuelta = codigoVueloVuelta;
		FechaSalidaVuelta = fechaSalidaVuelta;
		HoraSalidaVuelta = horaSalidaVuelta;
		DuraciónVueloVuelta = duraciónVueloVuelta;
		AeropuertoOrigenVuelta = aeropuertoOrigenVuelta;
		AeropuertoDestinoVuelta = aeropuertoDestinoVuelta;
	}
	public Aeropuerto getAeropuertoOrigenVuelta() {
		return AeropuertoOrigenVuelta;
	}
	public void setAeropuertoOrigenVuelta(Aeropuerto aeropuertoOrigenVuelta) {
		AeropuertoOrigenVuelta = aeropuertoOrigenVuelta;
	}
	public Aeropuerto getAeropuertoDestinoVuelta() {
		return AeropuertoDestinoVuelta;
	}
	public void setAeropuertoDestinoVuelta(Aeropuerto aeropuertoDestinoVuelta) {
		AeropuertoDestinoVuelta = aeropuertoDestinoVuelta;
	}
	public String getCodigoVueloVuelta() {
		return CodigoVueloVuelta;
	}
	public void setCodigoVueloVuelta(String codigoVueloVuelta) {
		CodigoVueloVuelta = codigoVueloVuelta;
	}
	public String getFechaSalidaVuelta() {
		return FechaSalidaVuelta;
	}
	public void setFechaSalidaVuelta(String fechaSalidaVuelta) {
		FechaSalidaVuelta = fechaSalidaVuelta;
	}
	public String getHoraSalidaVuelta() {
		return HoraSalidaVuelta;
	}
	public void setHoraSalidaVuelta(String horaSalidaVuelta) {
		HoraSalidaVuelta = horaSalidaVuelta;
	}
	public String getDuraciónVueloVuelta() {
		return DuraciónVueloVuelta;
	}
	public void setDuraciónVueloVuelta(String duraciónVueloVuelta) {
		DuraciónVueloVuelta = duraciónVueloVuelta;
	}
	@Override
	public String toString() {
		return super.toString()+"VueloVuelta [CodigoVueloVuelta=" + CodigoVueloVuelta + ", FechaSalidaVuelta=" + FechaSalidaVuelta
				+ ", HoraSalidaVuelta=" + HoraSalidaVuelta + ", DuraciónVueloVuelta=" + DuraciónVueloVuelta
				+ ", AeropuertoOrigenVuelta=" + AeropuertoOrigenVuelta + ", AeropuertoDestinoVuelta="
				+ AeropuertoDestinoVuelta + "]";
	}
	
	
	

}

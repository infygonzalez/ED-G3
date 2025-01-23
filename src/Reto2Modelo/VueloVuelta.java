package Reto2Modelo;

public class VueloVuelta extends VueloIda {
	
	private String CodigoVueloVuelta;
	private String FechaSalidaVuelta;
	private String HoraSalidaVuelta;
	private String DuraciónVueloVuelta;
	private Aeropuerto AeropuertoOrigenVuelta;
	private Aeropuerto AeropuertoDestinoVuelta;
	private Aerolinea Aerolinea;

	
	public VueloVuelta(String eventoID, String nombreEvento, String precio, Viaje viajeID, String codigoVuelo,
			String fechaSalida, String horaSalida, String duracionVuelo, Aeropuerto aeropuertoOrigen,
			Aeropuerto aeropuertoDestino, Reto2Modelo.Aerolinea aerolinea, String codigoVueloVuelta,
			String fechaSalidaVuelta, String horaSalidaVuelta, String duraciónVueloVuelta,
			Aeropuerto aeropuertoOrigenVuelta, Aeropuerto aeropuertoDestinoVuelta, Reto2Modelo.Aerolinea aerolinea2) {
		super(eventoID, nombreEvento, precio, viajeID, codigoVuelo, fechaSalida, horaSalida, duracionVuelo,
				aeropuertoOrigen, aeropuertoDestino, aerolinea);
		CodigoVueloVuelta = codigoVueloVuelta;
		FechaSalidaVuelta = fechaSalidaVuelta;
		HoraSalidaVuelta = horaSalidaVuelta;
		DuraciónVueloVuelta = duraciónVueloVuelta;
		AeropuertoOrigenVuelta = aeropuertoOrigenVuelta;
		AeropuertoDestinoVuelta = aeropuertoDestinoVuelta;
		Aerolinea = aerolinea2;
	}
	
	public Aerolinea getAerolinea() {
		return Aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		Aerolinea = aerolinea;
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
				+ AeropuertoDestinoVuelta + ", Aerolinea=" + Aerolinea + "]";
	}

	
	
	

}

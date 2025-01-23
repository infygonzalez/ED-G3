package Reto2Modelo;

public class VueloVuelta extends VueloIda {
	
	private String CodigoVueloVuelta;
	private String FechaSalidaVuelta;
	private String HoraSalidaVuelta;
	private String DuraciónVueloVuelta;
	
	public VueloVuelta(String eventoID, String nombreEvento, String precio,Viaje viaje, String codigoVuelo, String fechaSalida,
			String horaSalida, String duracionVuelo, String codigoVueloVuelta, String fechaSalidaVuelta,
			String horaSalidaVuelta, String duraciónVueloVuelta) {
		super(eventoID, nombreEvento, precio, viaje, codigoVuelo, fechaSalida, horaSalida, duracionVuelo);
		CodigoVueloVuelta = codigoVueloVuelta;
		FechaSalidaVuelta = fechaSalidaVuelta;
		HoraSalidaVuelta = horaSalidaVuelta;
		DuraciónVueloVuelta = duraciónVueloVuelta;
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
		return  super.toString()+"VueloVuelta [CodigoVueloVuelta=" + CodigoVueloVuelta + ", FechaSalidaVuelta=" + FechaSalidaVuelta
				+ ", HoraSalidaVuelta=" + HoraSalidaVuelta + ", DuraciónVueloVuelta=" + DuraciónVueloVuelta + "]";
	}
	
	

}

package Reto2Modelo;

public class VueloVuelta {
	private String CodigoVueloVuelta;
	private String FechaSalidaVuelta;
	private String HoraSalidaVuelta;
	private String DuraciónVueloVuelta;
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
		return "VueloVuelta [CodigoVueloVuelta=" + CodigoVueloVuelta + ", FechaSalidaVuelta=" + FechaSalidaVuelta
				+ ", HoraSalidaVuelta=" + HoraSalidaVuelta + ", DuraciónVueloVuelta=" + DuraciónVueloVuelta + "]";
	}
	
	

}

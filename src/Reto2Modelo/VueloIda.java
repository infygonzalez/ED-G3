package Reto2Modelo;

public class VueloIda {

	private String CodigoVuelo;
	private String FechaSalida;
	private String HoraSalida;
	private String DuracionVuelo;
	
	
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
		return "VueloIda [CodigoVuelo=" + CodigoVuelo + ", FechaSalida=" + FechaSalida + ", HoraSalida=" + HoraSalida
				+ ", DuracionVuelo=" + DuracionVuelo + "]";
	}
	
	
	
}



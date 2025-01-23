package Reto2Modelo;

public class Alojamiento extends Evento {
	private String NombreHotel;
	private String Ciudad;
	private Double PrecioEuros;
	private String FechaEntrada;
	private String FechaSalida;
	private String Tipo;

	public Alojamiento(String eventoID, String nombreEvento, String precio,Viaje viaje, String nombreHotel, String ciudad,
			Double precioEuros, String fechaEntrada, String fechaSalida, String tipo) {
		super(eventoID, nombreEvento, precio, viaje);
		NombreHotel = nombreHotel;
		Ciudad = ciudad;
		PrecioEuros = precioEuros;
		FechaEntrada = fechaEntrada;
		FechaSalida = fechaSalida;
		Tipo = tipo;
	}

	public String getNombreHotel() {
		return NombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		NombreHotel = nombreHotel;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public Double getPrecioEuros() {
		return PrecioEuros;
	}

	public void setPrecioEuros(Double precioEuros) {
		PrecioEuros = precioEuros;
	}

	public String getFechaEntrada() {
		return FechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	@Override
	public String toString() {
		return  super.toString()+"Alojamiento [NombreHotel=" + NombreHotel + ", Ciudad=" + Ciudad + ", PrecioEuros=" + PrecioEuros
				+ ", FechaEntrada=" + FechaEntrada + ", FechaSalida=" + FechaSalida + ", Tipo=" + Tipo + "]";
	}

}

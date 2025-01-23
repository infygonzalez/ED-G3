package Reto2Modelo;

public class Agencia {
	
	private String NombreAgencia;
	private String Logo;
	private String ColorMarca;
	private int NumeroEmpleados;
	private String TipoAgencia;

	
	public String getNombreAgencia() {
		return NombreAgencia;
	}
	public void setNombreAgencia(String nombreAgencia) {
		NombreAgencia = nombreAgencia;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String getColorMarca() {
		return ColorMarca;
	}
	public void setColorMarca(String colorMarca) {
		ColorMarca = colorMarca;
	}
	public int getNumeroEmpleados() {
		return NumeroEmpleados;
	}
	public void setNumeroEmpleados(int numeroEmpleados) {
		NumeroEmpleados = numeroEmpleados;
	}
	public String getTipoAgencia() {
		return TipoAgencia;
	}
	public void setTipoAgencia(String tipoAgencia) {
		TipoAgencia = tipoAgencia;
	}

	@Override
	public String toString() {
		return "Agencia [NombreAgencia=" + NombreAgencia + ", Logo=" + Logo + ", ColorMarca=" + ColorMarca
				+ ", NumeroEmpleados=" + NumeroEmpleados + ", TipoAgencia=" + TipoAgencia + "]";
	}
}
	

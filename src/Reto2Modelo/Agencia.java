package Reto2Modelo;

public class Agencia {
	
	private String NombreAgencia;
	private String Logo;
	private String ColorMarca;
	private int NumeroEmpleados;
	private String TipoAgencia;

	public Agencia() {
		
	}
	
	public Agencia(String nombreAgencia, String logo, String colorMarca, int numeroEmpleados, String tipoAgencia) {
		super();
		NombreAgencia = nombreAgencia;
		Logo = logo;
		ColorMarca = colorMarca;
		NumeroEmpleados = numeroEmpleados;
		TipoAgencia = tipoAgencia;
	}
	
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
	

package Reto2Modelo;

import java.util.ArrayList;

public class Agencia {
	
	private String NombreAgencia;
	private String Logo;
	private String ColorMarca;
	private int NumeroEmpleados;
	private String TipoAgencia;
	 private ArrayList<Viaje> Viajes;

	public Agencia() {
		
	}

	public Agencia(String nombreAgencia, String logo, String colorMarca, int numeroEmpleados, String tipoAgencia,
			ArrayList<Viaje> viajes) {
		NombreAgencia = nombreAgencia;
		Logo = logo;
		ColorMarca = colorMarca;
		NumeroEmpleados = numeroEmpleados;
		TipoAgencia = tipoAgencia;
		Viajes = viajes;
	}

	public ArrayList<Viaje> getViajes() {
		return Viajes;
	}

	public void setViajes(ArrayList<Viaje> viajes) {
		Viajes = viajes;
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
				+ ", NumeroEmpleados=" + NumeroEmpleados + ", TipoAgencia=" + TipoAgencia + ", Viajes=" + Viajes + "]";
	}

	
}
	

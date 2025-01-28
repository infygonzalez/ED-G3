package Reto2Controlador;

import Reto2Modelo.Agencia;
import Reto2Modelo.Gestor;

public class Controlador {

	public Agencia login(String usuario,String contraseña) {
		Gestor gestor = new Gestor();
		return gestor.login(usuario,contraseña);
	}
	public void  insertarAgencia(Agencia agencia) {
		Gestor gestor = new Gestor();
		gestor.insertarAgencia(agencia);
	}
}

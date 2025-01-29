package Reto2Controlador;

import java.util.ArrayList;

import Reto2Modelo.Aerolinea;
import Reto2Modelo.Aeropuerto;
import Reto2Modelo.Agencia;
import Reto2Modelo.Gestor;
import Reto2Modelo.Pais;
import Reto2Modelo.SQLQueries;
import Reto2Modelo.Viaje;



public class Controlador {

	public Agencia login(String usuario,String contraseña) {
		Gestor gestor = new Gestor();
		return gestor.login(usuario,contraseña);
	}
	public void  insertarAgencia(Agencia agencia) {
		Gestor gestor = new Gestor();
		gestor.insertarAgencia(agencia);
	}
	public ArrayList<Viaje> getListaViajes(ArrayList<Pais> paises,Agencia agencia){
		ArrayList<Viaje> viajes = null;
		Gestor gestor = new Gestor();
		viajes = gestor.buscarTodosViajes(paises,agencia);
		return viajes;
	}
	public ArrayList<Pais> getListaPaises(){
		ArrayList<Pais> paises = null;
		Gestor gestor = new Gestor();
		paises = gestor.buscarTodosPaises();
		return paises;
	}
	public ArrayList<Aeropuerto> getListaAeropuertos(){
		ArrayList<Aeropuerto> aeropuertos = null;
		Gestor gestor = new Gestor();
		aeropuertos = gestor.buscarTodosAeropuertos();
		return aeropuertos;
	}
	public ArrayList<Aerolinea> getListaAerolineas(){
		ArrayList<Aerolinea> aerolineas = null;
		Gestor gestor = new Gestor();
		aerolineas = gestor.buscarTodosAerolineas();
		return aerolineas;
	}
}

package Reto2Controlador;

import java.util.ArrayList;

import Reto2Modelo.Aerolinea;
import Reto2Modelo.Aeropuerto;
import Reto2Modelo.Agencia;
import Reto2Modelo.Alojamiento;
import Reto2Modelo.Gestor;
import Reto2Modelo.Otros;
import Reto2Modelo.Pais;
import Reto2Modelo.SQLQueries;
import Reto2Modelo.Viaje;
import Reto2Modelo.Vuelo;

public class Controlador {

	public Agencia login(String usuario, String contraseña) {
		Gestor gestor = new Gestor();
		return gestor.login(usuario, contraseña);
	}

	public void insertarAgencia(Agencia agencia) {
		Gestor gestor = new Gestor();
		gestor.insertarAgencia(agencia);
	}

	public ArrayList<Viaje> getListaViajes(ArrayList<Pais> paises, Agencia agencia) {
		ArrayList<Viaje> viajes = null;
		Gestor gestor = new Gestor();
		viajes = gestor.buscarTodosViajes(paises, agencia);
		return viajes;
	}

	public ArrayList<Vuelo> getListaVuelos(Viaje viaje, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		ArrayList<Vuelo> vuelos = null;
		Gestor gestor = new Gestor();
		vuelos = gestor.buscarTodosVuelos(viaje, aeropuertos, aerolineas);
		return vuelos;
	}

	public ArrayList<Alojamiento> getListaAlojamiento(Viaje viaje) {
		ArrayList<Alojamiento> alojamientos = null;
		Gestor gestor = new Gestor();
		alojamientos = gestor.buscarTodosAlojamiento(viaje);
		return alojamientos;
	}

	public ArrayList<Otros> getListaOtros(Viaje viaje) {
		ArrayList<Otros> otrosLista = null;
		Gestor gestor = new Gestor();
		otrosLista = gestor.buscarTodosOtros(viaje);
		return otrosLista;
	}

	public ArrayList<Pais> getListaPaises() {
		ArrayList<Pais> paises = null;
		Gestor gestor = new Gestor();
		paises = gestor.buscarTodosPaises();
		return paises;
	}

	public ArrayList<Aeropuerto> getListaAeropuertos() {
		ArrayList<Aeropuerto> aeropuertos = null;
		Gestor gestor = new Gestor();
		aeropuertos = gestor.buscarTodosAeropuertos();
		return aeropuertos;
	}

	public ArrayList<Aerolinea> getListaAerolineas() {
		ArrayList<Aerolinea> aerolineas = null;
		Gestor gestor = new Gestor();
		aerolineas = gestor.buscarTodosAerolineas();
		return aerolineas;
	}

	public boolean eliminarVuelo(Vuelo vuelo) {
		Gestor gestor = new Gestor();
		boolean valido = true;
		valido = gestor.eliminarVuelo(vuelo);

		if (vuelo.getEventoVueltaID() != null && valido == true) {
			valido = gestor.eliminarVuelo(vuelo.getEventoVueltaID());
		}
		return valido;
	}

	public boolean eliminarAlojamiento(Alojamiento alojamiento) {
		Gestor gestor = new Gestor();
		return gestor.eliminarAlojamiento(alojamiento);
	}

	public boolean eliminarOtros(Otros otro) {
		Gestor gestor = new Gestor();
		return gestor.eliminarOtros(otro);
	}

	public boolean eliminarViaje(Viaje viaje) {
		Gestor gestor = new Gestor();
		boolean valido = true;
		ArrayList<Vuelo> vuelosArray = viaje.getVuelos();
		for (int z = 0; z < vuelosArray.size(); z++) {
			if (valido == true) {
				valido = eliminarVuelo(vuelosArray.get(z));
			}
		}
		ArrayList<Alojamiento> alojamientosArray = viaje.getAlojamientos();
		for (int e = 0; e < alojamientosArray.size(); e++) {
			if (valido == true) {
				valido = eliminarAlojamiento(alojamientosArray.get(e));
			}
		}
		ArrayList<Otros> otrosArray = viaje.getOtros();
		for (int d = 0; d < otrosArray.size(); d++) {
			if (valido == true) {
				valido = eliminarOtros(otrosArray.get(d));
			}
		}

		if (valido == true) {
			valido = gestor.eliminarViaje(viaje);
		}
		return valido;
	}
	public void insertarViaje(Viaje viaje) {
		Gestor gestor = new Gestor();
		gestor.insertarViaje(viaje);
	}
	
	public void insertarAlojamiento(Alojamiento alojamiento) {
		Gestor gestor = new Gestor();
		gestor.insertarAlojamiento(alojamiento);
	}
	public void insertarOtros(Otros otro) {
		Gestor gestor = new Gestor();
		gestor.insertarOtros(otro);
	}
}

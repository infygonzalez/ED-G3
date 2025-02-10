package Reto2Controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

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

	public boolean insertarAgencia(Agencia agencia) {
		
		Gestor gestor = new Gestor();
		return gestor.insertarAgencia(agencia);
	}

	public ArrayList<Viaje> getListaViajes(ArrayList<Pais> paises, Agencia agencia) {
		ArrayList<Viaje> viajes = null;
		Gestor gestor = new Gestor();
		viajes = gestor.buscarTodosViajes(paises, agencia);
		viajes.sort(Comparator.comparing(Viaje::getFechaInicio));
		return viajes;
	}

	public ArrayList<Vuelo> getListaVuelos(Viaje viaje, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		ArrayList<Vuelo> vuelos = null;
		Gestor gestor = new Gestor();
		vuelos = gestor.buscarTodosVuelos(viaje, aeropuertos, aerolineas);
		return vuelos;
	}
	public int getSumaVuelos() {
		Gestor gestor = new Gestor();
		return gestor.getSumaVuelos();
	
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
		paises.sort(Comparator.comparing(Pais::getDescripcionPais));
		return paises;
	}

	public ArrayList<Aeropuerto> getListaAeropuertos() {
		ArrayList<Aeropuerto> aeropuertos = null;
		Gestor gestor = new Gestor();
		aeropuertos = gestor.buscarTodosAeropuertos();
		aeropuertos.sort(Comparator.comparing(Aeropuerto::getNombreAeropuerto));
		return aeropuertos;
	}

	public ArrayList<Aerolinea> getListaAerolineas() {
		ArrayList<Aerolinea> aerolineas = null;
		Gestor gestor = new Gestor();
		aerolineas = gestor.buscarTodosAerolineas();
		aerolineas.sort(Comparator.comparing(Aerolinea::getNombreAerolinea));
		return aerolineas;
	}
	public boolean insertarViaje(Viaje viaje) {
		Gestor gestor = new Gestor();
		return gestor.insertarViaje(viaje);
	}
	
	public boolean insertarAlojamiento(Alojamiento alojamiento) {
		Gestor gestor = new Gestor();
		return gestor.insertarAlojamiento(alojamiento);
	}
	public boolean insertarOtros(Otros otro) {
		Gestor gestor = new Gestor();
		return gestor.insertarOtros(otro);
	}
	public boolean insertarVuelo(Vuelo vuelo) {
		Gestor gestor = new Gestor();
		return gestor.insertarVuelo(vuelo);
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
	


	public void generarOfertaViaje(Viaje viaje) {
		String nombreArchivo =viaje.getNombreViaje().replaceAll(" ", "")+".txt";

		String urlArchivo = System.getProperty("user.home") + "/Desktop/"+nombreArchivo;
		double precioTotal =0;
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add("Nombre: "+viaje.getNombreViaje());
		cadenas.add("Fechas del viaje: "+viaje.getFechaInicio() + " al "+viaje.getFechaFin());
		cadenas.add("Tipo del viaje: "+viaje.getTipoViaje());
		cadenas.add("Pais: "+viaje.getPaisDestino().getDescripcionPais());
		cadenas.add("Descripción: "+viaje.getDescripciónViaje());
		cadenas.add("Servicios no incluidos: "+viaje.getServiciosNoIncluidos());
		cadenas.add("\n------------- EVENTOS -------------\n");
		for(Alojamiento alojamiento:viaje.getAlojamientos()) {
			cadenas.add("\n------------- ALOJAMIENTO - "+alojamiento.getNombreEvento()+" -------------");
			cadenas.add("Fechas de estancia: "+ alojamiento.getFechaEntrada()+" al "+ alojamiento.getFechaSalida() );
			String Tipo = "";
			if (alojamiento.getTipoHabitacion().equals("DB")) {
			    Tipo = "Doble";
			} else if (alojamiento.getTipoHabitacion().equals("DUI")) {
			    Tipo = "Doble con uso individual";
			} else if (alojamiento.getTipoHabitacion().equals("SIN")) {
			    Tipo = "Individual";
			} else if (alojamiento.getTipoHabitacion().equals("TPL")) {
			    Tipo = "Triple";
			}
			cadenas.add("Estancia en "+alojamiento.getNombreHotel() + " ("+alojamiento.getCiudad() + ") en una habitación " + Tipo );
			cadenas.add("Precio de la estancia: "+alojamiento.getPrecio()+"€");
			precioTotal = precioTotal+ Double.parseDouble(alojamiento.getPrecio());
		}
		for(Otros otro:viaje.getOtros()) {
			cadenas.add("\n------------- "+otro.getNombreEvento()+"-------------");
			cadenas.add("Fecha: "+ otro.getFecha() );
			cadenas.add("Precio: "+otro.getPrecio()+"€");
			cadenas.add("Descripción: "+otro.getDescripcion());
			precioTotal = precioTotal+ Double.parseDouble(otro.getPrecio());
		}
		for(Vuelo vuelo:viaje.getVuelos()) {
			cadenas.add("\n------------- VUELO -- "+vuelo.getNombreEvento()+ "-------------");
			cadenas.add("Precio: "+vuelo.getPrecio()+"€" );
			precioTotal = precioTotal+ Double.parseDouble(vuelo.getPrecio());

			cadenas.add("\n------------- VUELO DE IDA -------------");
			cadenas.add(vuelo.getAeropuertoOrigen().getNombreAeropuerto() +" a "+vuelo.getAeropuertoDestino().getNombreAeropuerto() );
			cadenas.add("Código de vuelo: "+vuelo.getCodigoVuelo() );
			cadenas.add("Aerolinea: "+vuelo.getAerolinea().getNombreAerolinea() );
			cadenas.add("Fecha y hora: "+ vuelo.getFechaSalida() +" a las "+ vuelo.getHoraSalida() + " y el vuelo dura "+vuelo.getDuracionVuelo() );
			if(vuelo.getEventoVueltaID() != null) {
				cadenas.add("\n------------- VUELO DE VUELTA -------------");
				cadenas.add(vuelo.getEventoVueltaID().getAeropuertoOrigen().getNombreAeropuerto() +" a "+vuelo.getEventoVueltaID().getAeropuertoDestino().getNombreAeropuerto() );
				cadenas.add("Código de vuelo: "+vuelo.getEventoVueltaID().getCodigoVuelo() );
				cadenas.add("Aerolinea: "+vuelo.getEventoVueltaID().getAerolinea().getNombreAerolinea() );
				cadenas.add("Fecha y hora: "+ vuelo.getEventoVueltaID().getFechaSalida() +" a las "+ vuelo.getEventoVueltaID().getHoraSalida() + " y el vuelo dura "+vuelo.getEventoVueltaID().getDuracionVuelo() );
			}
		
		}
		cadenas.add("---------------PRECIO TOTAL: "+precioTotal+"€ ---------------" );

		try {
		
			FileWriter fichero = new FileWriter(urlArchivo);

			PrintWriter pw = new PrintWriter(fichero);
			for (int i = 0; i < cadenas.size(); i++) {
				pw.println(cadenas.get(i));
			}
			fichero.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "¡El informe del viaje "+viaje.getNombreViaje()+" se ha creado correctamente en el escritorio con el nombre "+nombreArchivo+"!",viaje.getNombreViaje(),
				JOptionPane.INFORMATION_MESSAGE);
	}
}

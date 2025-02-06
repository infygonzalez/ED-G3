package Reto2Modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestorTest {
	Agencia agencia;
	Viaje viaje;
	Gestor gestor;
	String hola;
	ArrayList<Pais> paises;
	ArrayList<Aeropuerto> aeropuertos;
    ArrayList<Aerolinea> aerolineas;
	@Before
	public void iniciarGestor() {
		gestor = new Gestor();
		agencia = new Agencia();
		paises = gestor.buscarTodosPaises();
		aeropuertos = gestor.buscarTodosAeropuertos();
	    aerolineas = gestor.buscarTodosAerolineas();
		agencia.setNombreAgencia("Agencia Test");
		agencia.setColorMarca("#ff5733");
		agencia.setLogo("https://google.com");
		agencia.setNumeroEmpleados("Entre 2 y 10 empleados");
		agencia.setTipoAgencia("mayorista");
		agencia.setContraseña("3421");
		viaje = new Viaje();
		viaje.setNombreAgencia(agencia);
		viaje.setNombreViaje("Viaje a Madrid");
		viaje.setTipoViaje("Novios");
		for (Pais pais : paises) {
			if (pais.getDescripcionPais().equals("ALEMANIA")) {
				viaje.setPaisDestino(pais);
			}
		}
		viaje.setFechaInicio("2025/03/01");
		viaje.setFechaFin("2023/03/05");
		viaje.setDescripciónViaje("Viaje a Barcelona de 4 dias");
		viaje.setServiciosNoIncluidos("No incluye alojamiento.");
	}

	@Test
	public void test1_InsertarAgencia() {
		boolean agenciaNueva = gestor.insertarAgencia(agencia);
		assertTrue("La agencia no se crea correctamente", agenciaNueva);
	}

	@Test
	public void test2_Login() {
		agencia = gestor.login("Agencia Test", "3421");
		assertTrue("El login no es correcto", agencia instanceof Agencia);
	}

	@Test
	public void test3_InsertarViaje() {
		boolean viajeCreado = gestor.insertarViaje(viaje);
		assertTrue("El viaje no se crea correctamente", viajeCreado);
	}

	@Test
	public void test4_InsertarAlojamiento() {
		Alojamiento alojamiento = new Alojamiento();
		alojamiento.setViajeID(viaje);
		alojamiento.setNombreEvento("Alojamiento Madrid");
		alojamiento.setPrecio("100");
		alojamiento.setNombreHotel("Hotel 1");
		alojamiento.setFechaEntrada("2025/03/01");
		alojamiento.setFechaSalida("2025/03/05");
		alojamiento.setCiudad("Madrid");
		alojamiento.setTipoHabitacion("DB");
		boolean alojamientoCreado = gestor.insertarAlojamiento(alojamiento);
		assertTrue("El alojamiento no se crea correctamente", alojamientoCreado);

	}

	@Test
	public void test5_InsertarOtros() {
		Otros otros = new Otros();
		otros.setViajeID(viaje);
		otros.setNombreEvento("Buceos Madrid");
		otros.setPrecio("100");
		otros.setFecha("2025/03/03");
		otros.setDescripcion("Es muy divertido poder bucear en la fuente de la ciudad");
		boolean OtroCreado = gestor.insertarOtros(otros);
		assertTrue("El evento  no se crea correctamente", OtroCreado);
	}

	@Test
	public void testInsertarVuelo() {
		Vuelo vuelo= new Vuelo();
		vuelo.setViajeID(viaje);
		vuelo.setNombreEvento("Vuelo a Madrid");
		vuelo.setPrecio("200");
		vuelo.setDuracionVuelo("1:30");
		for (Aerolinea aerolinea : aerolineas) {
			if (aerolinea.getNombreAerolinea().equals("RYNAIR")) {
				vuelo.setAerolinea(aerolinea);
			}
		}
		vuelo.setCodigoVuelo("4352f");
		vuelo.setHoraSalida("07:33");
		vuelo.setFechaSalida("2025/03/01");
		for (Aeropuerto aeropuerto : aeropuertos) {
			if (aeropuerto.getNombreAeropuerto().equals("Santiago de Compostela")) {
				vuelo.setAeropuertoOrigen(aeropuerto);

			}
			if (aeropuerto.getNombreAeropuerto().equals("Madrid")) {
				vuelo.setAeropuertoDestino(aeropuerto);
			}
		}
		boolean VueloCreado = gestor.insertarVuelo(vuelo);
		assertTrue("El vuelo no se crea correctamente", VueloCreado);
		
		
	}

	@Test
	public void testBuscarTodosViajes() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTodosVuelos() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTodosAlojamiento() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTodosOtros() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTodosPaises() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTodosAeropuertos() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTodosAerolineas() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVuelo() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarVuelo() {
		
	}

	@Test
	public void testEliminarAlojamiento() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarOtros() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarViaje() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSumaVuelos() {
		fail("Not yet implemented");
	}
}

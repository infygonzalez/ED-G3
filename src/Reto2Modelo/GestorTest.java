package Reto2Modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import Reto2Modelo.Gestor;

public class GestorTest {

	@Test
	public void testLoginCorrecto() {
		Gestor gestor = new Gestor();
		Agencia login = gestor.login("Viajes Erreka-Mari", "1234");
		assertTrue("El login no es correcto",login instanceof Agencia);
	}
	@Test
	public void testLoginIncorrecto() {
		Gestor gestor = new Gestor();
		Agencia login = gestor.login("Viajes", "1342");
		assertFalse("El login no es correcto",login instanceof Agencia);
	}

	@Test
	public void testInsertarAgencia() {
		Gestor gestor = new Gestor();
		Agencia agencia = new Agencia();
		agencia.setNombreAgencia("aaa");
		agencia.setColorMarca("#ff5733");
		agencia.setLogo("https://google.com");
		agencia.setNumeroEmpleados("Entre 2 y 10 empleados");
		agencia.setTipoAgencia("mayorista");
		agencia.setContraseña("3421");
		boolean agenciaNueva= gestor.insertarAgencia(agencia);
		assertTrue("La agencia no se crea correctamente",agenciaNueva);
	
	}

	@Test
	public void testBuscarTodosViajes() {
		
		
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

}

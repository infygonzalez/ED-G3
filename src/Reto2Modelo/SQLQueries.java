package Reto2Modelo;

public class SQLQueries {
	// SELECTS

	public static final String SELECT_AGENCIA_NOMBRE_CONTRASEÑA = "SELECT * FROM agencia WHERE NombreAgencia = ? and Contraseña = ?";
	public static final String SELECT_VIAJES_AGENCIA = "SELECT * FROM viaje WHERE NombreAgencia=?";
	public static final String SELECT_TODOS_PAISES = "SELECT * FROM Pais ";
	public static final String SELECT_TODOS_AEROPUERTOS = "SELECT * FROM Aeropuerto ";
	public static final String SELECT_TODOS_AEROLINEAS = "SELECT * FROM Aerolinea ";
	public static final String SELECT_VUELOS_VIAJE = "SELECT * FROM Vuelo v WHERE ViajeID = ? AND (v.EventoVueltaID IS NOT NULL  OR v.EventoVueltaID IS NULL AND v.EventoID NOT IN (SELECT  EventoVueltaID FROM Vuelo WHERE EventoVueltaID IS NOT NULL));";
	public static final String SELECT_ALOJAMIENTO_VIAJE = "SELECT * FROM alojamiento WHERE ViajeID=?";
	public static final String SELECT_OTROS_VIAJE = "SELECT * FROM otros WHERE ViajeID=?";

	//INSERTS
	public static final String INSERT_AGENCIA = "insert into Agencia  values ('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
}

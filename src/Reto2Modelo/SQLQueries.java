package Reto2Modelo;

public class SQLQueries {
	// SELECTS

	public static final String SELECT_AGENCIA_NOMBRE_CONTRASEÑA = "SELECT * FROM agencia WHERE NombreAgencia = ? and Contraseña = ?";
	public static final String SELECT_VIAJES_AGENCIA = "SELECT * FROM viaje WHERE NombreAgencia=?";
	public static final String SELECT_TODOS_PAISES = "SELECT * FROM Pais ";
	public static final String SELECT_TODOS_AEROPUERTOS = "SELECT * FROM Aeropuerto ";
	public static final String SELECT_TODOS_AEROLINEAS = "SELECT * FROM Aerolinea ";

	//INSERTS
	public static final String INSERT_AGENCIA = "insert into Agencia  values ('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
}

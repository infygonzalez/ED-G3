package Reto2Modelo;

public class SQLQueries {
	// SELECTS
	public static final String SELECT_AGENCIA_NOMBRE_CONTRASEÑA = "SELECT * FROM agencia WHERE NombreAgencia = ? and Contraseña = ?";
	
	//INSERTS
	public static final String INSERT_AGENCIA = "insert into Agencia  values ('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
}

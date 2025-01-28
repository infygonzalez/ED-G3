package Reto2Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Gestor {
	public Agencia login(String usuario, String contraseña) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		Agencia agencia = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_AGENCIA_NOMBRE_CONTRASEÑA;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, usuario);
			sentencia.setString(2, contraseña);
			resultSet = sentencia.executeQuery();
			 
			if (resultSet.isBeforeFirst() &&resultSet.next()) {
				agencia = new Agencia();
				agencia.setNombreAgencia(resultSet.getString("NombreAgencia"));
				agencia.setLogo(resultSet.getString("Logo"));
				agencia.setColorMarca(resultSet.getString("ColorMarca"));
				agencia.setNumeroEmpleados(resultSet.getString("NumeroEmpleados"));
				agencia.setTipoAgencia(resultSet.getString("TipoAgencia"));

			}
			/*
			 * while (resultSet.next()) { Alumno alumno = new Alumno();
			 * alumno.setDni(resultSet.getString("dni"));
			 * alumno.setNombre(resultSet.getString("nombre"));
			 * alumno.setApellidos(resultSet.getString("apellidos"));
			 * alumno.setGrupo(resultSet.getString("grupo"));
			 * alumno.setFecNacimiento(resultSet.getString("fecNacimiento"));
			 * alumnos.add(alumno); }
			 */
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return agencia;
	}
}

 package com.ejercicios.bd.ejemplo06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mariadb.jdbc.export.ExceptionFactory.SqlExceptionFactory;

public class ConexionBD {
	private final static String HOST = "10.10.32.7";
	private final static String PORT = "3306";
	private final static String DB = "ligafutbito";
	private final static String USER = "root";
	private final static String PASSWORD = "abc123.";

	public static Connection conexion;
	public static Statement sentencia;

	public static boolean conectar() {

		String cadenaConexion = "jdbc:mariadb://" + HOST + ":" + PORT + "/" + DB;

		try {
			conexion = DriverManager.getConnection(cadenaConexion, USER, PASSWORD);

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean desconectar() {
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		return true;
	}

}

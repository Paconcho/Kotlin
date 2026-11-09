package com.ejercicios.bd.ejemplo03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private final static String HOST = "10.10.32.7";
	private final static String PORT = "3306";
	private final static String DB = "ligafutbito";
	private final static String USER = "root";
	private final static String PASSWORD = "abc123.";

	public static void listarEquipos() {

		String cadenaConexion;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		cadenaConexion = "jdbc:mariadb://" + HOST + ":" + PORT + "/" + DB;

		try {
			con = DriverManager.getConnection(cadenaConexion, USER, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery(
		            "SELECT id_equipo, nombre, ciudad, fundacion " + 
		            "FROM equipo " + 
		            "ORDER BY nombre, ciudad");
			
			while(rs.next()) {
				System.out.printf("%-5d %-20s %-10s %d\n",
		                rs.getInt(1),
		                rs.getString(2),
		                rs.getString(3),
		                rs.getInt(4));
		    }
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
			}
		}

	}
}

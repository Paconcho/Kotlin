package com.ejercicios.bd.ejemplo02;

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
	
	
	public static void testBD() {
		
		String cadenaConexion;
		
		cadenaConexion = "jdbc:mariadb://" + HOST + ":" + PORT + "/" + DB;
		
		try(Connection con = DriverManager.getConnection(cadenaConexion, USER, PASSWORD)){

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT VERSION() AS version");
			
			if(rs.next()) {
				System.out.println(rs.getString("version"));
			}
			
		}catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

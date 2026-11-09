package com.ejercicios.bd.ejemplo06;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilidadesBD {

	public static boolean crearTabla(String nombreTabla) {

		if (ConexionBD.conectar()) {
			try {
				Statement st = ConexionBD.conexion.createStatement();
				st.executeUpdate ("CREATE TABLE IF NOT EXISTS " + nombreTabla + " (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " + 
                        "nombre VARCHAR(30) NOT NULL" +
                        ")");
				ConexionBD.desconectar();
			} catch (SQLException e) {
				System.out.println("Error : " + e.getMessage());
				return false;
			}
			return true;
		}
		return false;
	}
	
	public static boolean insertarDatos() {

		if (ConexionBD.conectar()) {
			try {
				Statement st = ConexionBD.conexion.createStatement();
				st.executeUpdate ("INSERT INTO provincia(id,nombre)"
						+ "VALUES (1, 'Ourense'),"
						+ "(2, 'Pontevedra')");
				ConexionBD.desconectar();
			} catch (SQLException e) {
				System.out.println("Error : " + e.getMessage());
				return false;
			}
			return true;
		}
		return false;
	}
	
	public static String obtenerDatos() {

		StringBuilder resultado = new StringBuilder();
		
		if (ConexionBD.conectar()) {
			try {
				Statement st = ConexionBD.conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT nombre "
						+ "FROM provincia");
				
				while(rs.next()) {
					resultado.append(rs.getString("nombre")).append("\n");
				}
				
				ConexionBD.desconectar();
			} catch (SQLException e) {
				System.out.println("Error : " + e.getMessage());
				return null;
			}
			return resultado.toString();
		}
		return null;
	}
}


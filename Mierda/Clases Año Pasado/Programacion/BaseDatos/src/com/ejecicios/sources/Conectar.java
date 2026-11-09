package com.ejecicios.sources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Conectar {
	
	private static String RUTA = "datosConexion";
	
	public static String leerArchivo() {
		
		String linea;
		String[] partes;
		
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))){
			while((linea = br.readLine()) != null) {
				partes = linea.split(":");
				String estupido = partes[0];
				String values = partes[1];
				 
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}


	public static boolean conectar() {
		
		
		Connection conexion;
		Statement sentencia;

		String host;
		String port;
		String bd;
		String user;
		String password;
		
		String cadenaConexion = "jdbc:mariadb://" + host + ":" + port + "/" + bd;

		try {
			conexion = DriverManager.getConnection(cadenaConexion, user, password);

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	
}

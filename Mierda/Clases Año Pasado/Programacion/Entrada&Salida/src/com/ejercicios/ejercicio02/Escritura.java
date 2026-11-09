package com.ejercicios.ejercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {
	
	private static final String RUTA = "E:\\Programacion\\notas.txt";
	
	/**
	 * Empleamos try-with-resources
	 * @param vector
	 */
	
	public static void leer() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(RUTA))){
		String linea;
		while((linea = br.readLine()) != null) {
			System.out.println(linea);
		}
	}catch(IOException e) {
		System.err.println("Error de escritura " + e.getMessage());
	}
			
  }
}

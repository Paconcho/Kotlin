package com.ejercicios.ejercicio03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Operativa {
private static final String RUTA = "/com/resources/texto.txt";
	
	/**
	 * Empleamos try-with-resources
	 * @param vector
	 */
	
	public static void estadisticas() {
		
		String linea;
		String[] palabras;
		int numLineas = 0;
		int numPalabras = 0;
		
		InputStream input = Operativa.class.getResourceAsStream(RUTA);
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(input))){
			
			while((linea = br.readLine()) != null) {
				numLineas++;
				palabras = linea.split("\\s+");
				numPalabras += palabras.length;
				
			}
			System.out.println("Numero de lineas: " + numLineas + "Numero Palabras: " + numPalabras);
		}catch(IOException e) {
			System.err.println("Error de escritura " + e.getMessage());
		}
	}
			
  }


package com.ejercicios.ejercicio04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.ejercicios.ejercicio03.Operativa;

public class Archivo {
	private static final String RUTA_ESCRITURA = "/com/resources/aprobados.txt";
	private static final String RUTA_LECTURA = "/com/resources/notas.txt";
		
		/**
		 * Empleamos try-with-resources
		 * @param vector
		 */
		
		public static void aprobados() {
			
			String linea;
			String[] partes;

			
			try (BufferedReader br = new BufferedReader(new FileReader(RUTA_LECTURA));
					BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ESCRITURA))){
				
				while((linea = br.readLine()) != null) {
					partes = linea.split(":");
					try {
					if(Double.parseDouble(partes[1]) >= 5) {
						bw.write(linea);
						bw.newLine();
					}
					}catch(NumberFormatException e) {
						System.out.println("Error: " + e.getMessage());
					}
				}
				
			}catch(IOException e) {
				System.err.println("Error de escritura " + e.getMessage());
			}
		}
}

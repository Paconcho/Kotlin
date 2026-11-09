package com.ejercicios.ejercicio05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ejercicios.ejercicio03.Operativa;

public class Escritura {
	private static final String productos = "/com/resources/productos.txt";
		
		/**
		 * Empleamos try-with-resources
		 * @param vector
		 */
		
		public static void aumento() {
			
			String linea;
			String[] partes;
			double precio;
			List<String> lineas = new ArrayList<>();

			
			try (BufferedReader br = new BufferedReader(new FileReader(productos))){
				
				while((linea = br.readLine()) != null) {
					partes = linea.split(",");
					try {
						precio = Double.parseDouble(partes[1]);
						precio *= 1.10;
						
						lineas.add(String.format("%s, %.2f", partes[0], precio));
						
					}catch(NumberFormatException e) {
						System.out.println("Error : " + e.getMessage());
					}
				}
			}catch(IOException e) {
				System.err.println("Error de escritura " + e.getMessage());
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(productos))){
				for(String l : lineas) {
				bw.write(l);
				bw.newLine();
				}
			}catch(IOException e) {
				System.out.println("Error: " + e.getMessage());
			}	
		}
}

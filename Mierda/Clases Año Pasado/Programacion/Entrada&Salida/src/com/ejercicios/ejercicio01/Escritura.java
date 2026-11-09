package com.ejercicios.ejercicio01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {
	private static final String RUTA = "E:\\Programacion\\notas.txt";
	
	/**
	 * Empleamos try-with-resources
	 * @param vector
	 */
	
	public static void escribir(String[] vector) {
		
		String[] linha;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))){
			
			for(String nota : vector) {
				linha = nota.split(",");
				bw.write(linha[0].trim() + ": " + linha[1].trim());
				bw.newLine();
			}
		
	}catch(IOException e) {
		System.out.println("Error de escritura " + e.getMessage());
	}
		
		
  }
}

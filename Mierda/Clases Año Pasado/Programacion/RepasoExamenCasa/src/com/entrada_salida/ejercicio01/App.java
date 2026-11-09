package com.entrada_salida.ejercicio01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
	private static final String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\entrada_salida\\ejercicio01\\notas.txt";
	public static void main(String[] args) {
		
		String[] calificaciones = {
				"Anxela, 4.5", "Alex, 6.7",
				"Jose, 3.5", "Claudia, 8.4",
				"Luis, 7.2", "Pepe, 2.5",
				"Lucia, 8.6", "Duvan, 0.5"	
		};
		
		EscribirCalificaciones(calificaciones);	
	}

	private static void EscribirCalificaciones(String[] vector) {
		String[] linea;
		try(BufferedWriter br = new BufferedWriter(new FileWriter(RUTA))){
				for (String valor : vector) {
					linea = valor.split(",");
					br.write(linea[0].trim() + "," + linea[1].trim());
					br.newLine();
				}
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

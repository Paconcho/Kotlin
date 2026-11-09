package com.entrada_salida.ejercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
	
	private static final String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\entrada_salida\\ejercicio01\\notas.txt"; 
	
	public static void main(String[] args) {
		
		mostrarCalificaciones();
		
	}

	private static void mostrarCalificaciones() {
		
		String linea;
		
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))){
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

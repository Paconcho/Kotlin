package com.entrada_salida.ejercicio03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
	
	private static final String RUTA = "/com/sources/texto.txt";
	
	public static void main(String[] args) {
		
		contar();	
	}

	private static void contar() {
		
		String linea;
		String[] palabras;
		int numPalabras = 0;
		int numLineas = 0;
		
		InputStream input = App.class.getResourceAsStream(RUTA);
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(input))){
			while((linea = br.readLine()) != null) {
				numLineas++;
				palabras = linea.split("\\\\s+");
				numPalabras += palabras.length;
			}
			System.out.println("El numero de palabras es: " + numPalabras + " y el de lineas es: " + numLineas);
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

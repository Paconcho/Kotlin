package com.entrada_salida.ejercicio04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
	
	private static final String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\entrada_salida\\ejercicio04    \\notas.txt";
	private static final String RUTA2 = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\entrada_salida\\ejercicio04\\Aprobados.txt";
	
	public static void main(String[] args) {
	
		leerArchivo();
	
	}

	private static void leerArchivo() {
		String linea; 
		String[] partes;
		
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA));
				BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA2))){
			while((linea = br.readLine()) != null) {
				partes = linea.split(",");
				
				try {
					if(Double.parseDouble(partes[1]) >= 5) {
						bw.write(linea);
						bw.newLine();
					}
				}catch(IOException e) {
					System.out.println("Error: " + e.getMessage());
				}
				//System.out.println(linea);
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

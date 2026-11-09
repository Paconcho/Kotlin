package com.entrada_salida.ejercicio05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
	private static String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\entrada_salida\\ejercicio05\\precios.txt";
	private static String RUTA2 = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\entrada_salida\\ejercicio05\\precios2.txt";
	
	public static void main(String[] args) {
		
		String lineas;
		String[] partes;
		Double precio;
		List<String> linea = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA));
				BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA2))){
			
			while((lineas = br.readLine()) != null) {
				partes = lineas.split(",");
				precio = Double.parseDouble(partes[1]) * 1.1;
				linea.add(String.format("%s, %.2f", partes[0], precio));
			}
			
			for (String valor : linea) {
				bw.write(valor);
				bw.newLine();
			}
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}
	
}

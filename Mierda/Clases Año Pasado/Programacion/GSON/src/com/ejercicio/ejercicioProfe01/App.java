package com.ejercicio.ejercicioProfe01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.ejercicios.ejercicio05.Fotos;

public class App {
	
	private static List<Coches> coches;
	private static final String RUTA = "F:\\Programacion\\GSON\\Coches.txt";
	private static final String RUTA2 = "F:\\Programacion\\GSON\\Coches_ordenados.txt";
	
	public static void main(String[] args) {
		
		cargarCoches();
		ordenarCoches();
		guardarCoches();
		
	}

	private static void guardarCoches() {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA2))){
			for(Coches coche : coches) {
				bw.write(coche.getMarca());
				bw.write(";");
				bw.write(coche.getModelo());
				bw.write(";");
				bw.write(String.valueOf(coche.getPrecio()));
				bw.newLine();
			}
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

	private static void ordenarCoches() {
		
		//coches.sort(new Comparator<Coches>);
		
		    Collections.sort(coches, new Comparator<Coches>() {
		        @Override
		        public int compare(Coches c1, Coches c2) {
		            return c1.getMarca().compareTo(c2.getMarca());
		        }
		    });
		}
	
	

	private static void cargarCoches() {
		coches = new ArrayList<>();
		String linea;
		String[] datos;
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))){
			while((linea = br.readLine()) != null) {
				datos = linea.split(";");
				coches.add(new Coches(
						datos[0],
						datos[1],
						Double.parseDouble(datos[2])));
			}
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

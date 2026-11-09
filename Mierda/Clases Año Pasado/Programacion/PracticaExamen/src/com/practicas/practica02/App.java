package com.practicas.practica02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {

	private static final String RUTA = "F:\\Programacion\\PracticaExamen\\futbolistas.txt";
	private static final String RUTA2 = "F:\\Programacion\\PracticaExamen\\futbolistasTOP.txt";

	public static void main(String[] args) {

		ArrayList<Futbolista> futbolistas = new ArrayList();
		ArrayList<Futbolista> futbolistasTOP;
		
		leerFutbolistas(futbolistas);
		filtrarFutbolistas(futbolistas);
		// ordenarFutbolistas();
		// escribirFutbolista();
	}

	private static void escribirFutbolista() {

	}

	private static void ordenarFutbolistas() {
		
	}

	private static void filtrarFutbolistas(ArrayList<Futbolista> futbolistas) {
		ArrayList<Futbolista> lista = new ArrayList();
		
		for (Futbolista f : futbolistas) {
           if(f.getMarca() < 11) {
        	   lista.add(f);
        	   System.out.println(f);
           }
        }
		
	}

	private static void leerFutbolistas(ArrayList<Futbolista> futbolistas) {
		String linea;

		try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split("#");

				if (partes.length == 3) {
					String nombre = partes[0];
					int dorsal = Integer.parseInt(partes[1]);
					double marca = Double.parseDouble(partes[2]);

					futbolistas.add(new Futbolista(nombre, dorsal, marca));

				}
				
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error en la lectura: " + e.getMessage());
		}
	
		
	}
	
	
	
}

package com.practicas.practica02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App_profe {
private final static String RUTA_BASE = "d:/mosquera/";
	
	public static void main(String[] args) {
		
		ArrayList<Futbolista> futbolistas = new ArrayList();
		ArrayList<Futbolista> futbolistasTOP;
		
		futbolistas = leerFutbolistas("futbolistas.txt");
		futbolistasTOP = filtrarFutbolistas(futbolistas);
		ordenarFutbolistas(futbolistasTOP);
		escribirFutbolistas(futbolistasTOP, "futbolistasTOP.txt");
	}

	private static void ordenarFutbolistas(ArrayList<Futbolista> lista) {
		
		Collections.sort(lista, new Comparator<Futbolista>() {

			@Override
			public int compare(Futbolista o1, Futbolista o2) {
				return(Integer.compare(o1.getDorsal(), o2.getDorsal()));
			}
		});
		
	}

	private static void escribirFutbolistas(ArrayList<Futbolista> lista, String nombreArchivo) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE + nombreArchivo))){
			for (Futbolista futbolista : lista) {
				bw.write(futbolista.toString());
				bw.newLine();
			}			
		} catch(IOException e) {
			System.out.println("Error escribiendo archivo: " + e.getMessage());
		}
	}

	private static ArrayList<Futbolista> filtrarFutbolistas(ArrayList<Futbolista> futbolistas) {
		ArrayList<Futbolista> lista = new ArrayList();

		for (Futbolista futbolista : futbolistas) {
			if(futbolista.getMarca() < 11) {
				lista.add(futbolista);
			}
		}
		
		return lista;
	}

	private static ArrayList<Futbolista> leerFutbolistas(String nombreArchivo) {
		ArrayList<Futbolista> lista = new ArrayList();
		String linea;
		String [] partes;
		
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE + nombreArchivo))){
			while((linea = br.readLine())!= null) {
				try {
				partes = linea.split("#");
				lista.add(new Futbolista(partes[0],
										Integer.parseInt(partes[1]),
										Double.parseDouble(partes[2])));
				}catch(NumberFormatException e) {
				}
			}
			
		} catch(IOException e) {
			System.out.println("Error leyendo archivo: " + e.getMessage());
		}
		return lista;
	}
}

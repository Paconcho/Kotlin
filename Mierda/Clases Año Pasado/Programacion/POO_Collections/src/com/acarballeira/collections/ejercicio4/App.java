package com.acarballeira.collections.ejercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {
	
	private static HashMap<String, Integer> jugadores;
	
	public static void main(String[] args) {
		
		crearRanking();
		insertarDatosPrueba();
		mostrarRanking();
	}

	private static void mostrarRanking() {
		
		List<Map.Entry<String, Integer>> lista = new ArrayList(jugadores.entrySet());
		Collections.sort(lista, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
				
			}
			
		});
		
		//Mostramos el ranking
		/*
		for(String nombre : jugadores.keySet()) {
			System.out.println(nombre + ": " + jugadores.get(nombre));
		}
		*/
		
		for(Map.Entry<String, Integer> entry : lista) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
	}

	private static void insertarDatosPrueba() {
		jugadores.put("Julio", 4321 );
		jugadores.put("Luisa", 25);
		jugadores.put("Xan", 2855);
		jugadores.put("Anxela", 1518);
		jugadores.put("Clara", 2000);
		jugadores.put("Nunes", 25);
		jugadores.put("Ismael", 215);
		
	}

	private static void crearRanking() {
		
		jugadores = new HashMap();

	}
}

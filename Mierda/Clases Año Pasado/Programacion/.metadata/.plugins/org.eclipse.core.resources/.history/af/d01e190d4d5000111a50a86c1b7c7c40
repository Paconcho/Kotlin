package com.json;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App01 {
	
	private static ArrayList<Libro> libros;
	
	public static void main(String[] args) {
		
		crearLista();
		serializar();
		
	}

	private static void serializar() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String librosSerializados = gson.toJson(libros);
		System.out.println(librosSerializados);
		
	}

	private static void crearLista() {
		
		libros = new ArrayList<>();
		libros.add(new Libro("Hola que tal?", "Pepe", 1999, 14.99));
		libros.add(new Libro("Bien?", "Manuel", 2000, 17.99));
		libros.add(new Libro("Mal?", "Paco", 2001, 20.99));
		
	}
}

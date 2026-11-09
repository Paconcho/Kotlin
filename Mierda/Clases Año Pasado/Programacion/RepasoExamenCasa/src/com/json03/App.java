package com.json03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {

	private static ArrayList<Libro> libros;
	private static final String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\json03\\libros.json";

	public static void main(String[] args) {

		añadirLibros();
		serializar();
		
	}

	private static void serializar() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))){
			
			gson.toJson(libros, bw);
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		
		
	}

	private static void añadirLibros() {
		
		Persona Pepe = new Persona("Pape", "Español");
		Persona Manuel = new Persona("Manuel", "Español");
		Persona Paco = new Persona("Paco", "Español");
		
		libros = new ArrayList<>();
		
		libros.add(new Libro("Hola que tal?", List.of("Pepe"), 1999, 16.99));
		libros.add(new Libro("Bien?", List.of("Manuel"), 2000, 18.99));
		libros.add(new Libro("Mal?", List.of("Paco"), 2001, 20.99));
	}
}

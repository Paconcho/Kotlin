package com.Gson.ejercicios.ejercicio03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class App {
	
	private static ArrayList<Libros> libros;
	private static final String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\Gson\\ejercicios\\ejercicio03\\libros.json";
	
	public static void main(String[] args) {
		
		crearLibros();
		serializar();
		
		
		
	}

	private static void serializar() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))){
				gson.toJson(libros, bw);
				System.out.println("Archivo guardado con exito en la ruta: " + RUTA);
		}catch(IOException e) { 
			System.out.println("Error: " + e.getMessage());
		}
		
	}

	private static void crearLibros() {
		Persona cervantes = new Persona("Cervantes", "Española");
		Persona marquez = new Persona("Gabriel García Márquez", "Española");
		Persona orwell = new Persona("George Orwell", "Estadounidense");
		Persona otroAutor = new Persona("John Doe", "Mexicano");
		Persona mosquera = new Persona("Julio Mosquera", "Portugués");
		Persona macias = new Persona("Xurxo Macías", "Alemán");
		Persona chancas = new Persona("Manuel Chancas", "Marroquí");
		
		libros = new ArrayList<>();
		
		libros.add(new Libros("El quijote", 542, List.of(cervantes)));
		libros.add(new Libros("Cien años de soledad", 256, List.of(marquez, otroAutor)));
		libros.add(new Libros("1984", 164, List.of(orwell)));
		libros.add(new Libros("Prados e Terrado", 423, List.of(mosquera, macias, chancas)));
	}
	
}

package com.ejercicios.ejercicio03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// IMPORTANTE: Asegúrate de que importe el Libro del paquete ejercicio03
import com.ejercicios.ejercicio03.Libro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	private static final String RUTA = "F:\\Programacion\\GSON\\Deportes2.json";
	private static List<Libro> libros;

	public static void main(String[] args) {
		crearLibrosProbas();
		gardarConFormato();
	}

	private static void crearLibrosProbas() {
		Persona cervantes = new Persona("Cervantes", "Española");
		Persona marquez = new Persona("Gabriel García Márquez", "Española");
		Persona orwell = new Persona("George Orwell", "Estadounidense");
		Persona otroAutor = new Persona("John Doe", "Mexicano");
		Persona mosquera = new Persona("Julio Mosquera", "Portugués");
		Persona macias = new Persona("Xurxo Macías", "Alemán");
		Persona chancas = new Persona("Manuel Chancas", "Marroquí");

		libros = new ArrayList<>();
		// List.of es perfecto para esto
		libros.add(new Libro("El Quijote", List.of(cervantes), 1605, 15));
		libros.add(new Libro("Cien años de soledad", List.of(marquez, otroAutor), 1967, 20));
		libros.add(new Libro("1984", List.of(orwell), 1949, 12));
		libros.add(new Libro("Prados e Terrado", List.of(mosquera, macias, chancas), 2024, 28));
	}

	private static void gardarConFormato() {
		// PrettyPrinting hace que el JSON sea legible para humanos
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {
			gson.toJson(libros, bw);
			System.out.println("Archivo guardado con éxito en: " + RUTA);
		} catch (IOException e) {
			System.out.println("Error guardando archivo: " + e.getMessage());
		}
	}
}
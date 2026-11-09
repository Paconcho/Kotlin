package com.ejercicios.ejercicio02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class App {
	
	// Asegúrate de que esta ruta sea correcta y el archivo tenga formato JSON válido
	private static final String RUTA = "F:\\Programacion\\GSON\\Deportes.json";
	private static List<Libro> libros;
	
	private static final String jsonEstatico = "["
			+ "{\"titulo\":\"El Quijote\",\"autor\":\"Cervantes\",\"año\":1605,\"precio\":15},"
			+ "{\"titulo\":\"Cien años de soledad\",\"autor\":\"García Márquez\",\"año\":1967,\"precio\":20},"
			+ "{\"titulo\":\"1984\",\"autor\":\"George Orwell\",\"año\":1949,\"precio\":12}" + "]";

	public static void main(String[] args) {
		crearBiblioteca();
		
		// Elige uno de los dos métodos para probar:
		// cargarJsonEstatico(); 
		cargarJsonDeArchivo();
		
		mostrarBibioteca();
	}

	private static void crearBiblioteca() {
		libros = new ArrayList<>();
	}

	/**
	 * Carga el JSON desde el archivo definido en RUTA
	 */
	private static void cargarJsonDeArchivo() {
		Gson gson = new Gson();
		
		try (FileReader reader = new FileReader(RUTA)) {
			// Convertimos el JSON directamente a un Array de objetos Libro
			Libro[] arrayLibros = gson.fromJson(reader, Libro[].class);
			 
			if (arrayLibros != null) {
				libros.addAll(Arrays.asList(arrayLibros));
			}
		} catch (IOException e) {
			System.out.println("Error al acceder al archivo: " + e.getMessage());
		} catch (JsonSyntaxException e) {
			System.out.println("Error de formato en el JSON: " + e.getMessage());
		}
	}

	/**
	 * Carga el JSON desde la variable String estática
	 */
	private static void cargarJsonEstatico() {
		Gson gson = new Gson();
		try {
			Libro[] arrayLibros = gson.fromJson(jsonEstatico, Libro[].class);
			if (arrayLibros != null) {
				libros.addAll(Arrays.asList(arrayLibros));
			}
		} catch (JsonSyntaxException e) {
			System.out.println("Error en JSON estático: " + e.getMessage());
		}
	}

	private static void mostrarBibioteca() {
		if (libros.isEmpty()) {
			System.out.println("La biblioteca está vacía.");
		} else {
			for (Libro libro : libros) {
				System.out.println(libro);
			}
		}
	}
}
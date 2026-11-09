package com.ejercicios.ejercicio04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ejercicios.ejercicio03.Persona;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {

	private static final String RUTA = "F:\\Programacion\\GSON\\Deportes2.json";
	private static List<Libro> libros;

	public static void main(String[] args) {
		crearBiblioteca();
		crearLibros();
		mostrar();
	}

	private static void crearLibros() {
		JsonArray librosArrayJson;
		List<Persona> listaAuxAutores;

		try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			librosArrayJson = JsonParser.parseReader(br).getAsJsonArray();

			for (JsonElement elemento : librosArrayJson) {
				JsonObject libroJson = elemento.getAsJsonObject();
				listaAuxAutores = new ArrayList<>();

				JsonArray autoresJson = libroJson.get("autores").getAsJsonArray();
				for (JsonElement elemento2 : autoresJson) {
					JsonObject autorJson = elemento2.getAsJsonObject();
					listaAuxAutores.add(new Persona(autorJson.get("nombre").getAsString(),
							autorJson.get("nacionalidad").getAsString()));
				}

				libros.add(new Libro(libroJson.get("titulo").getAsString(), listaAuxAutores,
						libroJson.has("ano") ? libroJson.get("ano").getAsInt() : libroJson.get("anio").getAsInt(),
						libroJson.get("precio").getAsDouble()));
			}

		} catch (IOException e) {
			System.out.println("Error de lectura: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error al procesar JSON: " + e.getMessage());
		}
	}

	private static void crearBiblioteca() {
		libros = new ArrayList<>();
	}

	private static void mostrar() {
		if (libros == null || libros.isEmpty()) {
			System.out.println("No hay libros cargados.");
		} else {
			for (Libro l : libros) {
				System.out.println(l);
			}
		}
	}
}
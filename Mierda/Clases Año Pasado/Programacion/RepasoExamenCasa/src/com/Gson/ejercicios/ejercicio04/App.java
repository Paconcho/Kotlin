package com.Gson.ejercicios.ejercicio04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {

	private static ArrayList<Libros> libros;
	private static final String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\Gson\\ejercicios\\ejercicio03\\libros.json";

	public static void main(String[] args) {

		crearBiblioteca();
		cargarLibros();

		Collections.sort(libros, new Comparator<Libros>() {

		    @Override
		    public int compare(Libros l1, Libros l2) {
		        String nomeAutor1 = l1.getAutores().get(0).getNombre();
		        String nomeAutor2 = l2.getAutores().get(0).getNombre();

		        return nomeAutor1.compareToIgnoreCase(nomeAutor2);
		    }
		});
	}

	private static void mostrar() {

		if (libros == null || libros.isEmpty()) {
			System.out.println("No hay libros");
		} else {
			for (Libros l : libros) {
				for (Persona p : l.getAutores()) {
					System.out.println(p.getNombre());
				}
			}
		}
	}

	private static void cargarLibros() {
		JsonArray librosArrayJson;
		ArrayList<Persona> listaAuxAutores;
		
		try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			librosArrayJson = JsonParser.parseReader(br).getAsJsonArray();

			for (JsonElement elemento : librosArrayJson) {
				JsonObject libroJson = elemento.getAsJsonObject();
				
				String titulo = libroJson.get("titulo").getAsString();
	            int paginas = libroJson.get("paginas").getAsInt();

				listaAuxAutores = new ArrayList<>();
				JsonArray autorJson = libroJson.get("autores").getAsJsonArray();

				for (JsonElement elemento2 : autorJson) {
					JsonObject autoresJson = elemento2.getAsJsonObject();

					listaAuxAutores.add(new Persona(autoresJson.get("nombre").getAsString(),
							autoresJson.get("nacionalidad").getAsString()));
				}
				Libros l = new Libros(titulo, paginas, listaAuxAutores);
	            libros.add(l);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	private static void crearBiblioteca() {
		libros = new ArrayList<>();
	}
}

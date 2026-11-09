package com.json02;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {

	private static ArrayList<Libro> libros;

	public static void main(String[] args) {

		String json = "[" + "{\"titulo\":\"El Quijote\",\"autor\":\"Cervantes\",\"anio\":1605,\"precio\":15.5},"
				+ "{\"titulo\":\"Cien años de soledad\",\"autor\":\"García Márquez\",\"anio\":1967,\"precio\":20.0},"
				+ "{\"titulo\":\"1984\",\"autor\":\"George Orwell\",\"anio\":1949,\"precio\":12.75}" + "]";
		
		deserializar(json);
		mostrar();
	}

	private static void deserializar(String json) {
		libros = new ArrayList<>();
		
		JsonArray arrayJson = JsonParser.parseString(json).getAsJsonArray();
		
		for(JsonElement elemento : arrayJson) {
			JsonObject objeto = elemento.getAsJsonObject();
			
			String titulo = objeto.get("titulo").getAsString();
			String autor = objeto.get("autor").getAsString();
			int año = objeto.get("anio").getAsInt();
			double precio = objeto.get("precio").getAsDouble();
			
			libros.add(new Libro(titulo, autor, año, precio));
		}
	}

	private static void mostrar() {
		
		for (Libro l : libros) {
			System.out.println(l);
		}
	}
}

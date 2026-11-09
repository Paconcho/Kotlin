package com.ejercicios.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

public class App {

	private static List<Libro> libros;

	public static void main(String[] args) {
		cargarLibrosPrueba();
		System.out.println(serializarLibros());
	}

	private static String serializarLibros() {
		String json;

		Gson gson = new Gson();

		try {
			json = gson.toJson(libros);
		} catch (JsonSyntaxException e) {
			System.out.println("Error en la serialización en sintaxis: " + e.getMessage());
			json = "";
		} catch (JsonParseException e) {
			System.out.println("Error en la a nivel de parseo: " + e.getMessage());
			json = "";
		} catch (Exception e) {
			System.out.println("Error genérico en la serialización: " + e.getMessage());
			json = "";
		}

		return json;
	}

	private static void cargarLibrosPrueba() {
		libros = new ArrayList<>();
		libros.add(new Libro("El Quijote", "Cervantes", 1605, 15));
		libros.add(new Libro("Cien años de soledad", "García Márquez", 1967, 20));
		libros.add(new Libro("1984", "George Orwell", 1949, 12));
	}
}

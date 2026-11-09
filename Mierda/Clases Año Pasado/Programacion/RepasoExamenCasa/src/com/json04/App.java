package com.json04;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

		libros = new ArrayList<>();
		
		mostrar();
		importar();

	}

	private static void importar() {
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))){
			JsonArray arrayJson = JsonParser.parseReader(br).getAsJsonArray();
			
			for(JsonElement elemento : arrayJson) {
				JsonObject Libro = elemento.getAsJsonObject();
				
				String titulo = Libro.get("titulo").getAsString();
                int anio = Libro.get("anio").getAsInt();
                double precio = Libro.get("precio").getAsDouble();
                
                JsonArray arrayAutores = Libro.get("autor").getAsJsonArray();
                ArrayList<Persona> listaAutoresAux = new ArrayList<>();
				
				for(JsonElement elemento2 : arrayAutores) {
					JsonObject Persona = elemento2.getAsJsonObject();
					
					String nombre = Persona.get("nombre").getAsString();
					String nacionalidad = Persona.get("nacionalidad").getAsString();
					
					listaAutoresAux.add(new Persona(nombre, nacionalidad));
				}
				libros.add(new Libro(titulo, listaAutoresAux, anio, precio));
			}
			
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		
	}

	private static void mostrar() {

		for (Libro l : libros) {
			System.out.println(l);
		}
	}

}

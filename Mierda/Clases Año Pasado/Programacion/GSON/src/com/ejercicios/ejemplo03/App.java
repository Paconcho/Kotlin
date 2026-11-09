package com.ejercicios.ejemplo03;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {
	public static void main(String[] args) {

		// Lista de personas
		List<Persona> personas = List.of(
					new Persona("Julio", 48),
					new Persona("Ana", 38),
					new Persona("Duvan calvo", 55)
				);
		Gson gson = new Gson();
		
		// SERIALIZAR esta lista de personas
		String listaSerializada = gson.toJson(personas);
		
		System.out.println(listaSerializada);
		
		// DES-SERIALIZACION
		// Supones que recibimos listaSerializada
		JsonArray vectorPersonas = JsonParser.parseString(listaSerializada).getAsJsonArray();
		
		String nombre;
		int edad;
		
		for (JsonElement objeto : vectorPersonas) {
			JsonObject personaJson = objeto.getAsJsonObject();
			
			if(personaJson.has("nombre")) {
			 nombre = personaJson.get("nombre").getAsString();
			}else {
				 nombre = "Desconocido";
			}
			
			if(personaJson.has("edad")) {
				edad = personaJson.get("edad").getAsInt();
			}else {
				edad = -1;
			}
			
			System.out.println(nombre + ": " + edad);
		}
		
		// Definir un array des-serializado
		Persona[] personasArray = gson.fromJson(listaSerializada, Persona[].class);

		
		
	}
}

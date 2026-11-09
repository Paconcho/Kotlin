package com.ejercicios.ejemplo02;

import com.google.gson.Gson;

public class App {
	public static void main(String[] args) {

		// Des-serializar
		String json = "{\"nombre\": \"Julio\", \"edad\": 20}";

		Gson gson = new Gson();
		Persona p = gson.fromJson(json, Persona.class);

		System.out.println(p.getNombre() + " " + p.getEdad());

	}
}

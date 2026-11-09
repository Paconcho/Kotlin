package com.ejercicios.ejemplo01;

import com.google.gson.Gson;

public class App {
	public static void main(String[] args) {
		
		//Crear objeto JAVA
		Persona p = new Persona("Julio", 40);
		
		//Crear instancia de GSON
		Gson gson = new Gson();
		
		//Serializar objeto JSON
		String objetoSerializado = gson.toJson(p);
		
		System.out.println(objetoSerializado);
		
	}
}

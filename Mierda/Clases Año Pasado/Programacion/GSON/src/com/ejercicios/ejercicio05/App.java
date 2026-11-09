package com.ejercicios.ejercicio05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class App {
	private static List<Fotos> photos;
	private static final String DIRECCION = "https://jsonplaceholder.typicode.com/photos";

	public static void main(String[] args) {

		cargarFotos();

	}

	private static void cargarFotos() {

		photos = new ArrayList<>();
		Gson gson = new Gson();

		try {
			URL url = new URL(DIRECCION);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			try (BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
				// Leemos y guardamos en un StringBuilder
				StringBuilder sbJson = new StringBuilder();
				String linea;
				while ((linea = br.readLine()) != null) {
					sbJson.append(linea);
				}
				// System.out.println(sbJson);
				// Procesar Json
				JsonArray photoArray = JsonParser.parseString(sbJson.toString()).getAsJsonArray();
				for (JsonElement elemento : photoArray) {
					try {
						JsonObject photoJson = elemento.getAsJsonObject();
						photos.add(new Fotos(photoJson.get("albumId").getAsInt(), photoJson.get("id").getAsInt(),
								photoJson.get("title").getAsString(), photoJson.get("url").getAsString(),
								photoJson.get("thumbnaiUrl").getAsString()));
					} catch (NullPointerException e) {
					}
				}

			} catch (JsonParseException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} catch (IOException | JsonParseException e) {
			System.out.println();
		}
	}
}

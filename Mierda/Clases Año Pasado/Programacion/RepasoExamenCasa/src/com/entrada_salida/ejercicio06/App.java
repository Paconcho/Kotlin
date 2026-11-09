package com.entrada_salida.ejercicio06;

import java.io.BufferedWriter;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {

	private static final String RUTA = "D:\\Programacion\\RepasoExamenCasa\\src\\com\\entrada_salida\\ejercicio06\\personas.dat";

	public static void main(String[] args) {

		escrituraBinario();

	}

	private static void escrituraBinario() {

		HashMap<String, Double> personas = new HashMap< >();
		personas.put("Paco", 12.1);
		personas.put("Andrea", 53.2);
		personas.put("Julia", 32.1);
		personas.put("Bruno", 64.2);

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(RUTA))) {
			for (Map.Entry<String, Double> entry : personas.entrySet()) {
				dos.writeUTF(entry.getKey());
				dos.writeDouble(entry.getValue());

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}

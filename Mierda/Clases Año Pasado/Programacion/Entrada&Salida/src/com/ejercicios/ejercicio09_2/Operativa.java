package com.ejercicios.ejercicio09_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Operativa {

	private static final String RUTA = "datos.txt";

	public static String leerAlumnosTexto() {

		String nombre;
		String DNI;
		int[] notas;
		double notaFinal;
		StringBuilder listado;

		List<Alumno> alumnos = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			while ((nombre = br.readLine()) != null) {
				DNI = br.readLine();
				notas = new int[3];
				notas[0] = Integer.parseInt(br.readLine());
				notas[1] = Integer.parseInt(br.readLine());
				notas[2] = Integer.parseInt(br.readLine());
				notaFinal = Double.parseDouble(br.readLine());
				alumnos.add(new Alumno(nombre, DNI, notas, notaFinal));

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		listado = new StringBuilder();

		if (alumnos.isEmpty()) {
			System.out.println("No se encontraron alumnos en el archivo.");
		} else {
			for (Alumno a : alumnos) {
				// System.out.println(a);
				listado.append(a.toString());
			}
		}
		return listado.toString();
	}

	private static final String RUTA_BINARIO = "datos.bin";

	// 1. Cambiamos void por String
	public static String leerAlumnosBinario() {

	    String nombre;
	    String DNI;
	    int[] notas;
	    double notaFinal;
	    // 2. Inicializamos aquí para evitar errores de compilación
	    StringBuilder listado = new StringBuilder();

	    List<Alumno> alumnos = new ArrayList<>();

	    try (DataInputStream br = new DataInputStream(new FileInputStream(RUTA_BINARIO))) {
	        // 3. Usamos un bucle while(true) o mantenemos el available si el archivo es pequeño
	        while (br.available() > 0) {
	            nombre = br.readUTF();
	            DNI = br.readUTF();
	            notas = new int[3];
	            notas[0] = br.readInt();
	            notas[1] = br.readInt();
	            notas[2] = br.readInt();
	            notaFinal = br.readDouble();
	            
	            alumnos.add(new Alumno(nombre, DNI, notas, notaFinal));
	        }
	    } catch (FileNotFoundException e) {
	        return "Error: El archivo no existe.";
	    } catch (IOException e) {
	        return "Error al leer el archivo: " + e.getMessage();
	    }

	    if (alumnos.isEmpty()) {
	        listado.append("No se encontraron alumnos en el archivo.");
	    } else {
	        for (Alumno a : alumnos) {
	            listado.append(a.toString()).append("\n"); // Añadimos un salto de línea por claridad
	        }
	    }
	    
	    return listado.toString();
	}
}


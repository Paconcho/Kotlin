package com.pruebas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class App2 {
	public static void main(String[] args) {
	
	//leerDeConsola();
	escribirTexto("Texto a escribir en fichero: ");
	escribirTexto2("Texto a escribir en fichero: ");
	escribirUnaSolaLinea("Texto a escribir en fichero: ");
	
	}
	
	private static void escribirTexto(String texto) {
		File f;
		f = new File("D:\\damdu1\\texto.txt");
		byte[] arrayTexto;
		
		try {
			FileOutputStream archivo = new FileOutputStream(f);
			arrayTexto = texto.getBytes();
			
			archivo.write(arrayTexto);
			archivo.close();
			
		}catch(IOException e) {
			System.out.println("Error de escritura. Fichero no existe: " + e.getMessage());
		}
	}
	
	private static void escribirTexto2(String texto) {
		File f;
		f = new File("D:\\damdu1\\texto.txt");
		
		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(texto);
			bw.close();
			
		}catch(IOException e) {
			System.out.println("Error de escritura: " + e.getMessage());
		}
	}
	
	private static void escribirUnaSolaLinea(String texto) {
		try {
			BufferedWriter bw =
					new BufferedWriter(new FileWriter(new File("D:\\damdu1\\texto.txt")));
			
			bw.write(texto);
			
			bw.close();
		}catch(IOException e) {
			System.out.println("Error de escritura " + e.getMessage());
		}
	}

	private static void leerDeConsola() {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String nombre;
		int edad;
		
		try {
		System.out.println("Introduce nombre: ");
			nombre = teclado.readLine();
		System.out.println("Introduce edad: ");
			edad = Integer.parseInt(teclado.readLine());
		}catch(NumberFormatException | IOException e) {
			System.out.println("Error de lectura: " + e.getMessage());
			nombre = "";
			edad = 0;
		}
		System.out.println(nombre + " - " + edad);
	}
}

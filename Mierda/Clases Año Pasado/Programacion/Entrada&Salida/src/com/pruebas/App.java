package com.pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class App {

	public static void main(String[] args) {

		//lerFicheiro();
		//lerFicheiro2();
		//lerFicheiro3();
		//lerFicheiro4();
		lerFicheiroTexto();
		
	}

	private static void lerFicheiro() {
		File f;
		InputStream input;
		try {
			f = new File("D:\\damdu1\\texto.txt");
			System.out.println(f.isDirectory());
			input = new FileInputStream(f);

			int data = input.read();
			while (data != -1) {
				// facemos algo cos datos
				System.out.print((char)data);
				data = input.read();
			}

			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("fichero no encotrado" + e.getMessage());
		} catch (IOException e) {
			System.out.println("eror en la salida" + e.getMessage());
		}
	}
	
	private static void lerFicheiro2() {
		InputStream input;
		try {
			input = new FileInputStream("D:\\damdu1\\texto.txt");

			int data = input.read();
			while (data != -1) {
				// facemos algo cos datos
				System.out.print((char)data);
				data = input.read();
			}

			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("fichero no encotrado" + e.getMessage());
		} catch (IOException e) {
			System.out.println("eror en la salida" + e.getMessage());
		}
	}
	
	private static void lerFicheiro3() {
		File f;
		Reader input;
		try {
			f = new File("D:\\damdu1\\texto.txt");
			input = new FileReader(f);

			int data = input.read();
			while (data != -1) {
				// facemos algo cos datos
				System.out.print((char)data);
				data = input.read();
			}

			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("fichero no encotrado" + e.getMessage());
		} catch (IOException e) {
			System.out.println("eror en la salida" + e.getMessage());
		}
	}
	
	/**
	 * LECTURA OPTIMIZADA
	 */
	
	private static void lerFicheiro4() {
		File f;
		Reader input;
		char[] vector = new char[5];
		int numLetrasLeidas;
		
		try {
			f = new File("D:\\damdu1\\texto.txt");
			input = new FileReader(f);
			while((numLetrasLeidas = input.read(vector)) != -1){
				System.out.print(new String(vector));
			}
			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("fichero no encotrado" + e.getMessage());
		} catch (IOException e) {
			System.out.println("eror en la salida" + e.getMessage());
		}
	}
	
	private static void lerFicheiroTexto() {
		File f;
		BufferedReader bf;
		String linea;
		
		try {
			f = new File("D:\\damdu1\\texto.txt");
			bf = new BufferedReader(new FileReader(f));
			
			while((linea = bf.readLine()) != null) {
				System.out.println(linea);
			}
			
			bf.close();
		} catch (FileNotFoundException e) {
			System.out.println("fichero no encotrado" + e.getMessage());
		} catch (IOException e) {
			System.out.println("eror en la salida" + e.getMessage());
		}
	}
	
}

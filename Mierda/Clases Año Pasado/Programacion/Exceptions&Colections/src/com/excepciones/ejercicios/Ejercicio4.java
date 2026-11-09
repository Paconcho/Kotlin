package com.excepciones.ejercicios;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce o nome do arquivo: ");
		String nome = sc.nextLine();
		
		try {
			InputStream ip = Ejercicio4.class.getResourceAsStream("/com/excepciones/ejercicios/" + nome);
			
			if(ip == null) {
				throw new FileNotFoundException("O archivo non se atopou");
			}
			
			try(Scanner scFile = new Scanner(ip)){
				System.out.println("----- Contenido -----");
				while(scFile.hasNext()) {
					System.out.println(scFile.nextLine());
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}finally {
			sc.close();
			System.out.println("Fin");
		}
		
		
	}
}

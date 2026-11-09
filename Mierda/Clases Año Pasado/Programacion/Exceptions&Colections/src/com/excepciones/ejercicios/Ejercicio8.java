package com.excepciones.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Ejercicio8 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char[] nombreArray = new char[10];
		boolean datos = false;
		
		while(!datos) {
			try {
				System.out.println("Introduce nombre: ");
					String nombre = sc.next();
				
					if(nombre.length() > 10) {
						throw new ArrayIndexOutOfBoundsException("O nome e demasiado largo");
					}
					
					for(int i = 0; i < nombre.length(); i++) {
						nombreArray[i] = nombre.charAt(i);
					}
					
					System.out.println("Introduce altura en metros: ");
						int altura = sc.nextInt();
						
					if (altura < 0) {
						throw new ArithmeticException("La altura no puede ser negativa");
					}
					 
					System.out.println("Introduce peso: ");
						int peso = sc.nextInt();
						
					double imc  = peso / (altura * altura);
					System.out.println("O imc e: " + imc);
					
					datos = true;
					
			}catch(ArithmeticException e) {
				System.out.println("Error: " + e.getMessage());
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
sc.close();
		
		
	}
}

package com.excepciones.ejercicios;

import java.util.Scanner;

public class App_ejercicio6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Introduce tu edad: ");
				int edad = sc.nextInt();
				
			if(edad < 0 	|| edad > 120) {
				throw new ejercicio6_EdadInvalidaException("La edad no puede ser menor que 0 ni mayor de 120");
			}
			System.out.println("Edad Registrada correctamente");
		}catch(ejercicio6_EdadInvalidaException e) {
			e.MostrarImaxe();
		}catch(Exception e) {
			System.out.println("Error en la entrada de datos");
		}
			sc.close();
		
		
	}
}

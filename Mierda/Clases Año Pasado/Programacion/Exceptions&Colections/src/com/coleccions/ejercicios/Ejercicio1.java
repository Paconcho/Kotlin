package com.coleccions.ejercicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> alumnos = new ArrayList<>();
		
		alumnos.add("Pepe");
		alumnos.add("Maria");
		alumnos.add("Ana");
		
		try {
			System.out.println("Lista actual: " + alumnos);
			System.out.println("Introduce o numero de alumno que quere ver: ");
				int numero = sc.nextInt();
			
			String nombre = alumnos.get(numero);
			
			System.out.println("O alumno na posicion " + numero + " e: " + nombre);
		}catch(InputMismatchException e) {
			System.out.println("Error: no se ha introducido un numero");
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Error: el numero introducico es mayor que el array");
		}
	}
}

package com.excepciones.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Introduce un numero: ");
				int n1 = sc.nextInt();
			System.out.println("Introduce otro numero: ");
				int n2 = sc.nextInt();
		}catch(ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			sc.close();
		}
		
			
	}
}

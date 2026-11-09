package com.excepciones.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio2 {
	public static void main(String[] args) {
		
		int[] datos = {10 ,20, 30, 40};
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Introduce una pasicion entre (0 - 3): ");
			int pos = sc.nextInt();
			System.out.println("O valor na posicion " + pos + " e: " + datos[pos]);
		}catch(InputMismatchException e){
			System.out.println("Erro: Debes introducir un numero enteiro");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: O numero introducido esta fora de rango");
		}catch(Exception e) {
			System.out.println("Produciuse un erro inesperado: " + e.getMessage());
		}finally {
			sc.close();
		}
		
	}
}

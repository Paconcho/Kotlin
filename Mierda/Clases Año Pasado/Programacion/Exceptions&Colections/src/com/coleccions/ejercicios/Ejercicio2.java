package com.coleccions.ejercicios;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Handler;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, String> productos = new HashMap<>();
		
		productos.put(100, "manzana");
		
		try {
			System.out.println("Introduce el codigo del producto que desea buscar");
				int codigo = sc.nextInt();
				
				if(productos.containsKey(codigo)) {
					System.out.println("Producto recopilado: " + productos.get(codigo));
				}else {
					System.out.println("No existe ese codigo");
				}
		}catch(InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

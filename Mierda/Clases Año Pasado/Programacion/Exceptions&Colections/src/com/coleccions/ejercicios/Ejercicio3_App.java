package com.coleccions.ejercicios;

import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio3_App {
	public static void main(String[] args) {
		
		TreeMap<String, Ejercicio3_Contacto> agenda = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("\n--- AGENDA TREEMAP ---");
            System.out.println("1. Engadir contacto");
            System.out.println("2. Buscar contacto por nome");
            System.out.println("3. Mostrar todos (ordenados)");
            System.out.println("4. Saír");
            System.out.print("Elixe unha opción: ");
            opcion = sc.nextInt();
            
            switch(opcion) {
            case 1:
            	sc.nextLine();
            	System.out.println("Introduce nombre: ");
            		String nombre = sc.nextLine();
            	
            	System.out.println("Telefono: ");
            		int telefono = sc.nextInt();
            		
            	agenda.put(nombre, new Ejercicio3_Contacto(nombre, telefono));
            	System.out.println("Agregado correctamente");
            	break;
            
            case 2:
            	sc.nextLine();
            	System.out.println("Nombre a buscar: ");
            		String buscar = sc.nextLine();
            		
            	if(agenda.containsKey(buscar)){
            		System.out.println("Atopado: " + agenda.get(buscar));
            	}else {
            		System.out.println("Non se atopou o contacto");
            	}
            	break;
            case 3:
            	sc.nextLine();
            	System.out.println("Lista de contactos ordenada: ");
            	for (Ejercicio3_Contacto c : agenda.values()) {
					System.out.println(c);
				}
            	break;
            }
		}while(opcion != 4);
		
	}
}

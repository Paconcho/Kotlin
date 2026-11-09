package com.coleccions.ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio567_App {
	
	private static ArrayList<Ejercicio567_Alumno> lista = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		cargardatos();
		int opcion;

		
		do {
            System.out.println("\n--- CRUD ALUMNOS ---");
            System.out.println("1. Alta de alumnos");
            System.out.println("2. Listar alumnos (For-each)");
            System.out.println("3. Buscar y eliminar por DNI");
            System.out.println("4. Saír");
            
    		opcion = sc.nextInt();

            switch (opcion) {
                case 1: altaAlumnos(); break;
                case 2: listarAlumnos(); break;
                case 3: eliminarAlumno(); break;
            }
        } while (opcion != 4);
    }

	private static void cargardatos() {
		lista.add(new Ejercicio567_Alumno("Ana García", "111A", "ASIR", 2000, false));
        lista.add(new Ejercicio567_Alumno("Zalo Pérez", "222B", "DAM", 1998, true));
        lista.add(new Ejercicio567_Alumno("Brais Mirás", "333C", "DAW", 2002, false));
	}
	
	private static void altaAlumnos() {
		System.out.println("--- ALTA ALUMNOS ---");
		System.out.print("Cantos alumnos desexa dar de alta? ");
        int num = sc.nextInt();
        
		for(int i = 0; i < num; i++) {
			System.out.println("Alumno " + (i + 1) + ":");
            System.out.print("Nome completo: "); String nome = sc.nextLine();
            System.out.print("DNI: "); String dni = sc.nextLine();
            System.out.print("Ciclo: "); String ciclo = sc.nextLine();
            System.out.print("Ano nacemento: "); int ano = sc.nextInt();
            System.out.print("Ten pendentes? (true/false): "); boolean p = sc.nextBoolean();
            sc.nextLine();
    		lista.add(new Ejercicio567_Alumno(nome, dni, ciclo, ano, p));
		}
	}

	private static void listarAlumnos() {
		if(lista.isEmpty()) {
			System.out.println("A lista esta baleira");
		}else {
			for(Ejercicio567_Alumno a : lista) {
				System.out.println(a);
			}
		}
	}
	
	private static void eliminarAlumno() {
		    System.out.print("Introduce o DNI do alumno que queres borrar: ");
		    String dniBusca = sc.nextLine();
		    
		    boolean atopado = false;

		    for (int i = 0; i < lista.size(); i++) {
		        if (lista.get(i).getDni().equalsIgnoreCase(dniBusca)) {
		            
		            lista.remove(i);
		            
		            System.out.println("Alumno con DNI " + dniBusca + " eliminado correctamente.");
		            atopado = true;
		            
		            break; 
		        }
		    }

		    if (!atopado) {
		        System.out.println("Erro: Non se atopou ningún alumno co DNI: " + dniBusca);
		    }
		
	
	
	}
}


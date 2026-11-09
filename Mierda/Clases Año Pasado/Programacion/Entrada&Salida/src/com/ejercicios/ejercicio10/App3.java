package com.ejercicios.ejercicio10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App3 {
private static ArrayList <Alumno> alumnos;
	
	public static void main(String[] args) {
		
		int opcion;
		crearListado();
		cargarAlumnosPrueba();
		
		do {
			menu();
			opcion = escogerOpcion();
			procesarAccion(opcion);			
		} while (opcion != 9);
		
	}

	private static void procesarAccion(int opcion) {
		
		switch(opcion) {
			case 1 -> altaAlumno();
			case 2 -> bajaAlumno();
			case 3 -> modificarAlumno();
			case 4 -> listarAlumnos();
			case 5 -> {
				Collections.sort(alumnos, new Comparator<Alumno>() {
					@Override
					public int compare(Alumno o1, Alumno o2) {
						return o1.getNombre().compareTo(o2.getNombre());
					}
				});
				System.out.println("Alumnos ordenados correctamente por nombre.");
			}
			case 6 -> {
				Collections.sort(alumnos, Comparator.comparing(Alumno::getDNI));
				System.out.println("Alumnos ordenados correctamente por DNI.");
			}
			case 7 -> {
				Collections.sort(alumnos, Comparator.comparing(Alumno::isPendientes).reversed());
				System.out.println("Alumnos ordenados correctamente por pendientes.");				
			}
			case 8 -> {
				Collections.sort(alumnos, new Comparator<Alumno>() {
					@Override
					public int compare(Alumno o1, Alumno o2) {
						int cicloComp = o1.getCiclo().compareToIgnoreCase(o2.getCiclo());
                        if (cicloComp != 0) return cicloComp;
                        int pendientesComp = Boolean.compare(o2.isPendientes(), o1.isPendientes());
                        if (pendientesComp != 0) return pendientesComp;
                        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
					}
				});
				System.out.println("Alumnos ordenados correctamente por ciclo, pendientes y nombre.");
			}
			case 9 ->{ 
			System.out.println("");
			System.out.printf("Saliendo ...");
			}
			default-> System.out.printf("Opción no válida");
		}
		
	}

	private static void modificarAlumno() {
		
		String nombre, dni, ciclo;
		String aux;
		int anhoNacimiento;
		boolean pendientes;
		Alumno alumno;
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				
		try {
			System.out.printf("Introduzca dni del alumno a actualizar: ");
			dni = teclado.readLine();
			if (!alumnos.contains(new Alumno("", dni, "", 0, false))) {
				System.out.println("No existe un alumno con ese DNI. Vuelva intentarlo más tarde");
			} else {
				alumno = alumnos.get(alumnos.indexOf(new Alumno("", dni, "", 0, false)));
				System.out.printf("Introduzca nombre ["+ alumno.getNombre() +"]: ");
				nombre = teclado.readLine();			
				System.out.printf("Introduzca ciclo [" + alumno.getCiclo() + "]:");
				ciclo = teclado.readLine();
				System.out.printf("Introduzca año de nacimiento [" + alumno.getNacimiento() + "]:");
				anhoNacimiento = Integer.parseInt(teclado.readLine());
				System.out.printf("Dime si tienes pendientes o no [S/n]: ");
				aux = teclado.readLine();
				if(aux.toLowerCase().equals("s")) {
					pendientes = true;
				} else {
					pendientes = false;
				}
			}
			teclado.close();
			
		} catch (NumberFormatException | IOException e) {	
			System.out.println("Error dando de alta a alumno " + e.getMessage());
		}		
	}

	private static void bajaAlumno() {	
		String dni;
		Alumno alumno;
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				
		try {
			System.out.printf("Introduzca dni del alumno a eliminar: ");
			dni = teclado.readLine();
			if (!alumnos.contains(new Alumno("", dni, "", 0, false))) {
				System.out.println("No existe un alumno con ese DNI. Vuelva intentarlo más tarde");
			} else {
				alumno = alumnos.get(alumnos.indexOf(new Alumno("", dni, "", 0, false)));
				alumnos.remove(alumno);
				//Expresión lambda
				alumnos.removeIf(a -> a.getDNI().equalsIgnoreCase(alumno.getDNI()));
				
				System.out.println("Alumno dado de baja correctamente");
			}
			//teclado.close();
			
		} catch (NumberFormatException | IOException e) {	
			System.out.println("Error dando de baja a alumno " + e.getMessage());
		}	
	}

	private static void altaAlumno() {
		
		String nombre, dni, ciclo;
		String aux;
		int anhoNacimiento;
		boolean pendientes;
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				
		try {
			System.out.printf("Introduzca dni: ");
			dni = teclado.readLine();
			if (alumnos.contains(new Alumno("", dni, "", 0, false))) {
				System.out.println("Existe ya un alumno con ese DNI. Vuelva intentarlo más tarde");
			} else {
				System.out.printf("Introduzca nombre: ");
				nombre = teclado.readLine();			
				System.out.printf("Introduzca ciclo: ");
				ciclo = teclado.readLine();
				System.out.printf("Introduzca año de nacimiento: ");
				anhoNacimiento = Integer.parseInt(teclado.readLine());
				System.out.printf("Dime si tienes pendientes o no [S/n]: ");
				aux = teclado.readLine();
				if(aux.toLowerCase().equals("s")) {
					pendientes = true;
				} else {
					pendientes = false;
				}
				alumnos.add(new Alumno(nombre, dni, ciclo, anhoNacimiento, pendientes));	
			}		
			teclado.close();
			
		} catch (NumberFormatException | IOException e) {	
			System.out.println("Error dando de alta a alumno " + e.getMessage());			
		}
		
	}

	private static int escogerOpcion() {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		
		System.out.printf("Introduzca una opción: ");
		try {
			opcion = Integer.parseInt(teclado.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Error: debe introducir un número");
			opcion = -1;
		}
		return opcion;
	}

	private static void menu() {
		System.out.println("\n--- MENÚ GESTIÓN DE ALUMNOS ---");
        System.out.println("1. Alta alumno");
        System.out.println("2. Baja alumno");
        System.out.println("3. Modificación alumno");
        System.out.println("4. Listado de alumnos");
        System.out.println("5. Ordenar por nombre");
        System.out.println("6. Ordenar por DNI");
        System.out.println("7. Ordenar por pendientes");
        System.out.println("8. Ordenar por ciclo, pendientes y nombre");
        System.out.println("9. Salir");
		
	}

	private static void listarAlumnos() {
		if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos en la lista.");
        } else {
            System.out.println("\n--- LISTADO DE ALUMNOS ---");
            for (Alumno a : alumnos) {
                System.out.println(a);
            }
        }
		
	}

	private static void cargarAlumnosPrueba() {
		alumnos.add(new Alumno("Xan Mosquera Pérez", "76727272F", "DAW", 1985, true));
		alumnos.add(new Alumno("Susana Gulín Martínez", "76007285K", "ASIR", 2001, false));
		alumnos.add(new Alumno("Anxela Chouza Carou", "49709852J", "ASIR", 2006, false));
		alumnos.add(new Alumno("Jorge Macías Rodríguez", "44296652W", "DAM", 1980, false));
	}

	private static void crearListado() {
		alumnos = new ArrayList();
		
	}
}

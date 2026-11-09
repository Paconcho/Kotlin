package com.ejercicios.ejercicio13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

	private static ArrayList<Alumnos> alumnos;
	private final static String FICHERO = "E:\\Programacion\\Entrada&Salida\\src\\com\\resources\\alumnos_13.bin";

	public static void main(String[] args) {

		int opcion;
		crearListado();
		//cargarAlumnosPrueba();
		cargarDatos();

		do {
			menu();
			opcion = escogerOpcion();
			procesarAccion(opcion);
		} while (opcion != 9);

	}

	private static void procesarAccion(int opcion) {

		switch (opcion) {
		case 1 -> altaAlumno();
		case 2 -> bajaAlumno();
		case 3 -> modificarAlumno();
		case 4 -> listarAlumnos();
		case 5 -> {
			Collections.sort(alumnos, new Comparator<Alumnos>() {
				@Override
				public int compare(Alumnos o1, Alumnos o2) {
					return o1.getNombre().compareTo(o2.getNombre());
				}
			});
			System.out.println("Alumnos ordenados correctamente por nombre.");
		}
		case 6 -> {
			Collections.sort(alumnos, Comparator.comparing(Alumnos::getDNI));
			System.out.println("Alumnos ordenados correctamente por DNI.");
		}
		case 7 -> {
			Collections.sort(alumnos, Comparator.comparing(Alumnos::isPendientes).reversed());
			System.out.println("Alumnos ordenados correctamente por pendientes.");
		}
		case 8 -> {
			Collections.sort(alumnos, new Comparator<Alumnos>() {
				@Override
				public int compare(Alumnos o1, Alumnos o2) {
					int cicloComp = o1.getCiclo().compareToIgnoreCase(o2.getCiclo());
					if (cicloComp != 0)
						return cicloComp;
					int pendientesComp = Boolean.compare(o2.isPendientes(), o1.isPendientes());
					if (pendientesComp != 0)
						return pendientesComp;
					return o1.getNombre().compareToIgnoreCase(o2.getNombre());
				}
			});
			System.out.println("Alumnos ordenados correctamente por ciclo, pendientes y nombre.");
		}
		case 9 -> {
			System.out.println("Guardando datos de la aplicación.");
			guardarDatos();
			System.out.printf("Saliendo ...");
		}
		default -> System.out.printf("Opción no válida");
		}

	}

	private static void cargarDatos() {

		File f = new File(FICHERO);
		if (f.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
				while (true) {
					alumnos = (ArrayList<Alumnos>) ois.readObject();
				}
			} catch (EOFException e) {

			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} else {
			System.out.println("No existe el fichero de carga de la aplicación");
		}

	}

	private static void guardarDatos() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
				oos.writeObject(alumnos);
			
			System.out.println("Datos guardados correctamente en: " + FICHERO);
		} catch (IOException e) {
			System.out.println("Error escribiendo en fichero: " + e.getMessage());
		}

	}

	private static void modificarAlumno() {

		String nombre, dni, ciclo;
		String aux;
		int anhoNacimiento;
		boolean pendientes;
		Alumnos alumno;

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.printf("Introduzca dni del alumno a actualizar: ");
			dni = teclado.readLine();
			if (!alumnos.contains(new Alumnos("", dni, "", 0, false))) {
				System.out.println("No existe un alumno con ese DNI. Vuelva intentarlo más tarde");
			} else {
				alumno = alumnos.get(alumnos.indexOf(new Alumnos("", dni, "", 0, false)));
				System.out.printf("Introduzca nombre [" + alumno.getNombre() + "]: ");
				nombre = teclado.readLine();
				System.out.printf("Introduzca ciclo [" + alumno.getCiclo() + "]:");
				ciclo = teclado.readLine();
				System.out.printf("Introduzca año de nacimiento [" + alumno.getNacimiento() + "]:");
				anhoNacimiento = Integer.parseInt(teclado.readLine());
				System.out.printf("Dime si tienes pendientes o no [S/n]: ");
				aux = teclado.readLine();
				if (aux.toLowerCase().equals("s")) {
					pendientes = true;
				} else {
					pendientes = false;
				}
			}
			// teclado.close();

		} catch (NumberFormatException | IOException e) {
			System.out.println("Error dando de alta a alumno " + e.getMessage());
		}
	}

	private static void bajaAlumno() {

		String dni;
		Alumnos alumno;

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.printf("Introduzca dni del alumno a eliminar: ");
			dni = teclado.readLine();
			if (!alumnos.contains(new Alumnos("", dni, "", 0, false))) {
				System.out.println("No existe un alumno con ese DNI. Vuelva intentarlo más tarde");
			} else {
				alumno = alumnos.get(alumnos.indexOf(new Alumnos("", dni, "", 0, false)));
				alumnos.remove(alumno);
				// Expresión lambda
				alumnos.removeIf(z -> z.getDNI().equalsIgnoreCase(alumno.getDNI()));

				System.out.println("Alumno dado de baja correctamente");
			}
			// teclado.close();

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
			if (alumnos.contains(new Alumnos("", dni, "", 0, false))) {
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
				if (aux.toLowerCase().equals("s")) {
					pendientes = true;
				} else {
					pendientes = false;
				}
				alumnos.add(new Alumnos(nombre, dni, ciclo, anhoNacimiento, pendientes));
			}
			// teclado.close();

		} catch (NumberFormatException | IOException e) {
			System.out.println("Error dando de alta a alumno " + e.getMessage());
		}

	}

	private static int escogerOpcion() {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int opcion;

		System.out.printf("Introduzca una opción: ");
		try {
			opcion = Integer.parseInt(teclado.readLine());
		} catch (IOException | NumberFormatException e) {
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
			for (Alumnos a : alumnos) {
				System.out.println(a);
			}
		}

	}

	private static void cargarAlumnosPrueba() {
		alumnos.add(new Alumnos("Xan Mosquera Pérez", "76727272F", "DAW", 1985, true));
		alumnos.add(new Alumnos("Susana Gulín Martínez", "76007285K", "ASIR", 2001, false));
		alumnos.add(new Alumnos("Anxela Chouza Carou", "49709852J", "ASIR", 2006, false));
		alumnos.add(new Alumnos("Jorge Macías Rodríguez", "44296652W", "DAM", 1980, false));
	}

	private static void crearListado() {
		alumnos = new ArrayList();

	}

}

package com.ejercicios.ejercicio09;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnoFichero {

	private static class Alumno {

		String nombre, dni;
		int[] eval;
		double nFinal;

		public Alumno(String nombre, String dni, int[] eval, double nFinal) {
			this.nombre = nombre;
			this.dni = dni;
			this.eval = eval;
			this.nFinal = nFinal;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner tec = new Scanner(System.in);
		List<Alumno> alumno = new ArrayList<>();
		System.out.println("Introduce alumnos (nombre en blanco para finalizar).");
		while (true) {
			System.out.print("Nombre: ");
			String nombre = tec.nextLine();
			if (nombre.isEmpty()) {
				break;
			}

			System.out.print("DNI: ");
			String dni = tec.nextLine();
			int[] eval = new int[3];
			for (int i = 0; i < 3; i++) {
				System.out.print("nota eval " + (i + 1) + ": ");
				eval[i] = tec.nextInt();
			}

			System.out.print("Nota final: ");
			double nFinal = tec.nextDouble();
			tec.nextLine();
			alumno.add(new Alumno(nombre, dni, eval, nFinal));
		}

		System.out.println("Grabando fichero de texto");
		var or = new BufferedWriter(new FileWriter("datos.txt"));
		for (Alumno it : alumno) {
			or.write(it.nombre + "\n");
			or.write(it.dni + "\n");
			for (int i = 0; i < 3; i++) {
				or.write("" + it.eval[i] + "\n");
			}
			or.write("" + it.nFinal + "\n");
		}
		or.close();

		System.out.println("Grabando fichero binario");
		var dos = new DataOutputStream(new FileOutputStream("datos.bin"));

		for (Alumno it : alumno) {
			dos.writeUTF(it.nombre);
			dos.writeUTF(it.dni);
			for (int i = 0; i < 3; i++) {
				dos.writeInt(it.eval[i]);
			}
			dos.writeDouble(it.nFinal);
		}
		dos.close();
	}
}

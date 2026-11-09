package com.ejercicios.ejercicio09;

import java.util.Arrays;

public class Alumno {

	String nombre;
	String DNI;
	int[] notas;
	double notaFinal;

	public Alumno(String nombre, String dNI, int[] notas, double notaFinal) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.notas = notas;
		this.notaFinal = notaFinal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	@Override
	public String toString() {
		return String.format("Alumno [nombre=%s, DNI=%s, notas=%s, notaFinal=%s]", nombre, DNI, Arrays.toString(notas),
				notaFinal);
	}

	
	
}

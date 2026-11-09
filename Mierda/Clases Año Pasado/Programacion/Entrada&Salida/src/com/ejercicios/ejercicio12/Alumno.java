package com.ejercicios.ejercicio12;

import java.util.Collections;
import java.util.Comparator;

public class Alumno {
	String nombre;
	String DNI;
	String ciclo;
	int nacimiento;
	boolean pendientes;
	
	public Alumno(String nombre, String DNI, String ciclo, int nacimiento, boolean pendientes) {
		super();
		this.nombre = nombre;
		DNI = DNI;
		this.ciclo = ciclo;
		this.nacimiento = nacimiento;
		this.pendientes = pendientes;
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
	public String getCiclo() {
		return ciclo;
	}
	
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public int getNacimiento() {
		return nacimiento;
	}
	
	public void setNacimiento(int nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public boolean isPendientes() {
		return pendientes;
	}
	
	public void setPendientes(boolean pendientes) {
		this.pendientes = pendientes;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", DNI=" + DNI + ", ciclo=" + ciclo + ", nacimiento=" + nacimiento
				+ ", pendientes=" + pendientes + "]";
	}
	
	
}

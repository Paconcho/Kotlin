package com.coleccions.ejercicios;

public class Ejercicio567_Alumno {
	    private String nombreCompleto;
	    private String dni;
	    private String ciclo;
	    private int anhoNacimiento;
	    private boolean pendientes;

	    public Ejercicio567_Alumno(String nombreCompleto, String dni, String ciclo, int anhoNacimiento, boolean pendientes) {
	        this.nombreCompleto = nombreCompleto;
	        this.dni = dni;
	        this.ciclo = ciclo;
	        this.anhoNacimiento = anhoNacimiento;
	        this.pendientes = pendientes;
	    }

	    public String getNombreCompleto() { return nombreCompleto; }
	    public String getDni() { return dni; }
	    public String getCiclo() { return ciclo; }
	    public boolean isPendientes() { return pendientes; }

	    @Override
	    public String toString() {
	        return String.format("DNI: %s | Nome: %s | Ciclo: %s | Ano: %d | Pendentes: %b",
	                dni, nombreCompleto, ciclo, anhoNacimiento, pendientes);
	    }
}

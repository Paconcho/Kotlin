package com.coleccions.ejercicios;

public class Ejercicio3_Contacto {
	    private String nombre;
	    private int telefono;

	    public Ejercicio3_Contacto(String nombre, int telefono) {
	        this.nombre = nombre;
	        this.telefono = telefono;
	    }

	    public String getNombre() { return nombre; }
	    public int getTelefono() { return telefono; }

	    @Override
	    public String toString() {
	        return "Nombre: " + nombre + " | Teléfono: " + telefono;
	    }
}

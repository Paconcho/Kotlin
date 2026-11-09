package com.Gson.ejercicios.ejercicio04;

public class Persona {
	String nombre;
	String nacionalidad;

	public Persona(String nombre, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return String.format("Persona [nombre=%s, nacionalidad=%s]", nombre, nacionalidad);
	}
	
	
}

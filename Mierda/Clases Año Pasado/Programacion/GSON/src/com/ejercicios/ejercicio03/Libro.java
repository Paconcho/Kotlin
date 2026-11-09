package com.ejercicios.ejercicio03;

import java.util.List;

public class Libro {
	private String titulo;
	private int anio;
	private double precio;
	private List<Persona> autores;

	public Libro() {
	}

	public Libro(String titulo, List<Persona> autores, int anio, double precio) {
		this.titulo = titulo;
		this.autores = autores;
		this.anio = anio;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Persona> getAutores() {
		return autores;
	}

	public void setAutores(List<Persona> autores) {
		this.autores = autores;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return String.format("Libro [titulo=%s, anio=%d, precio=%.2f, autores=%s]", titulo, anio, precio, autores);
	}
}
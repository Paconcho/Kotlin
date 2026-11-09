package com.ejercicios.ejercicio02;

public class Libro {
	private String titulo;
	private String autor; // Cambiado de List<Persona> a String
	private int año;
	private int precio;

	public Libro() {
	}

	public Libro(String titulo, String autor, int año, int precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", año=" + año + ", precio=" + precio + "]";
	}
}
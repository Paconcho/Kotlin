package com.json04;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	String titulo;
	List<Persona> autor;
	int anio;
	double precio;

	public Libro(String titulo, ArrayList<Persona> listaAutoresAux, int anio, double precio) {
		super();
		this.titulo = titulo;
		this.autor = listaAutoresAux;
		this.anio = anio;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Persona> getAutor() {
		return autor;
	}

	public void setAutor(List<Persona> autor) {
		this.autor = autor;
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
		return String.format("Libro [titulo=%s, autor=%s, año=%s, precio=%s]", titulo, autor, anio, precio);
	}

}

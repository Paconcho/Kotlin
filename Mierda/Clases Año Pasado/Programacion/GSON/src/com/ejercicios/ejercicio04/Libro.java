package com.ejercicios.ejercicio04;

import java.util.List;
import com.ejercicios.ejercicio03.Persona; // Importamos Persona del ejercicio anterior

public class Libro {
	private String titulo;
	private int ano;
	private double precio;
	private List<Persona> autores; // Antes tenías List<Libro>, eso daba error

	public Libro() {
	}

	public Libro(String titulo, List<Persona> autores, int ano, double precio) {
		this.titulo = titulo;
		this.autores = autores;
		this.ano = ano;
		this.precio = precio;
	}

	// Getters y Setters
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return String.format("Libro [titulo=%s, ano=%d, precio=%.2f, autores=%s]", titulo, ano, precio, autores);
	}
}
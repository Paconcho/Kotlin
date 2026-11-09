package com.Gson.ejercicios.ejercicio04;

import java.util.List;

public class Libros {
	String titulo;
	int paginas;
	List<Persona> autores;

	public Libros() {
	}

	public Libros(String titulo, int paginas, List<Persona> autores) {
		super();
		this.titulo = titulo;
		this.paginas = paginas;
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public List<Persona> getAutores() {
		return autores;
	}

	public void setAutores(List<Persona> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return String.format("Libros [titulo=%s, paginas=%s, autores=%s]", titulo, paginas, autores);
	}

	

}

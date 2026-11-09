package com.Gson.ejercicios.ejercicio03;

import java.util.List;

public class Libros {
	String titulo;
	int paginas;
	List<Persona> autores;

	public Libros() {
	}

	public Libros(String titulo, int paginas, List<com.Gson.ejercicios.ejercicio03.Persona> autores) {
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

	

}

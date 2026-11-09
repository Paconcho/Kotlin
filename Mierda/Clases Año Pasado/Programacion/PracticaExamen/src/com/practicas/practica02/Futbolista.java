package com.practicas.practica02;

public class Futbolista {
	String nombre;
	int dorsal;
	double marca;

	public Futbolista(String nombre, int dorsal, double marca) {
		super();
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public double getMarca() {
		return marca;
	}

	public void setMarca(double marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
	    return String.format("Futbolista:[Nombre: %s | Dorsal: %d | Marca: %.2f]", 
	                          nombre, dorsal, marca);
	}
}

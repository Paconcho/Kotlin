package com.ejercicio.ejercicioProfe01;

public class Coches {
	private String marca;
	private String modelo;
	private double precio;

	public Coches(String marca, String modelo, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}
	
	public Coches() {
		
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return String.format("%s %s - %.2f€", marca, modelo, precio);
	}
}
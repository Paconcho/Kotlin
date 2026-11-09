package com.ejercicios.ejercicio08;

import java.io.Serializable;

public class Deporte implements Serializable{

	private static final long serialVersionUID = 1L;
	String nombre;
	int jugadores;
	boolean olimpico;
	
	public Deporte(String nombre, int jugadores, boolean olimpico) {
		super();
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.olimpico = olimpico;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(int jugadores) {
		this.jugadores = jugadores;
	}
	
	public boolean isOlimpico() {
		return olimpico;
	}
	
	public void setOlimpico(boolean olimpico) {
		this.olimpico = olimpico;
	}

	@Override
	public String toString() {
		return String.format("%s || Jugadores: %s || Olimpico: %s", nombre, jugadores, olimpico);
	}

}

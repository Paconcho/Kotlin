package com.ejercicios.ejercicio03;

public class Persona {
	String persona;
	String nacionalidad;

	public Persona(String persona, String nacionalidad) {
		super();
		this.persona = persona;
		this.nacionalidad = nacionalidad;
	}
	
	public Persona() {
		
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return String.format("Persona [persona=%s, nacionalidad=%s]", persona, nacionalidad);
	}

}

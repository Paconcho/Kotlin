package com.excepciones.ejercicios;

class ejercicio3_MiExcepcion extends Exception{
	String msg;

	public ejercicio3_MiExcepcion(String msg) {
		super();
		this.msg = msg;
	}
	
	public void mostrarMensaxe() {
		System.out.println("Excepcion xenerada: " + msg);
	}
}

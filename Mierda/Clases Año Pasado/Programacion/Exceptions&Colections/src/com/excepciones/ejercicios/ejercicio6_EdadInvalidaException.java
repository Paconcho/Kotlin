package com.excepciones.ejercicios;

class ejercicio6_EdadInvalidaException extends Exception{
	
	String msg;
	public ejercicio6_EdadInvalidaException(String msg) {
		super();
		this.msg = msg;
	}
	
	public void MostrarImaxe() {
		System.out.println("Error: " + msg);
	}
}


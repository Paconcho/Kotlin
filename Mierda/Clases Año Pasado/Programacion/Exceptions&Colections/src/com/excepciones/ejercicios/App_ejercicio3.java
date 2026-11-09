package com.excepciones.ejercicios;

public class App_ejercicio3 {
	public static void main(String[] args) {
		
		try {
			throw new ejercicio3_MiExcepcion("Esta e a miña propia excepcion");
		}catch(ejercicio3_MiExcepcion e) {
			e.mostrarMensaxe();
		}
		
	}
}

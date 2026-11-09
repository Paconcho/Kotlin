package com.excepciones.ejercicios;

public class ejercicio1 {
	public static void main(String[] args) {
		
		try {
			throw new Exception("Isto e unha excepcion");
		}catch (Exception e) {
			System.out.println("Produciuse unha excepcion: " + e.getMessage());
		}finally {
			System.out.println("O programa executarase sen preocuparse si presenta erros");
		}
		
	}
}

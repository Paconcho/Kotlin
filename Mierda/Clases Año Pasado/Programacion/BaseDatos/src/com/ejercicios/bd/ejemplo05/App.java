package com.ejercicios.bd.ejemplo05;

public class App {
	
	public static void main(String[] args) {

		UtilidadesBD.crearTabla("provincia");
		//UtilidadesBD.insertarDatos();
		System.out.println(UtilidadesBD.obtenerDatos());
	}
}

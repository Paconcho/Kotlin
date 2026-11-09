package com.ejercicios.bd.ejemplo04;

public class App {
	
	public static void main(String[] args) {
		if(ConexionBD.conectar()) {
			System.out.println("Conexion exitosa");
			ConexionBD.desconectar();
		}else {
			System.out.println("No nos damos conectado");
		}

		
	}
}

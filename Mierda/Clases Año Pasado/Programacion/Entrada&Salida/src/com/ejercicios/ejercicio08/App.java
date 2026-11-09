package com.ejercicios.ejercicio08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
		
	private static final String RUTA = "E:\\Programacion\\Entrada&Salida\\src\\com\\resources\\deportes.bin";
	private static List<Deporte> listaDeportes;
		
	public static void main(String[] args) {
		
	crearLista();
	//cargasDatosEjemplo();
	//guardarDatos();
	cargarDAtos();
	mostrarLista();
		
	}

	private static void mostrarLista() {
		for(Deporte d : listaDeportes) {
			System.out.println(d);
		}
		
	}

	private static void cargarDAtos() {
		
		try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA))){
			listaDeportes = (List<Deporte>) entrada.readObject();
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void guardarDatos() {
		
		try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(RUTA))){
			saida.writeObject(listaDeportes);
			System.out.println("Datos gardados");
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}

	private static void cargasDatosEjemplo() {

		listaDeportes.add(new Deporte("Futbol", 11, true));
		listaDeportes.add(new Deporte("Baloncesto", 5, true));
		listaDeportes.add(new Deporte("Ajedrez", 2, false));
		
	}

	private static void crearLista() {
		listaDeportes = new ArrayList<Deporte>();	
	}
	
	
}

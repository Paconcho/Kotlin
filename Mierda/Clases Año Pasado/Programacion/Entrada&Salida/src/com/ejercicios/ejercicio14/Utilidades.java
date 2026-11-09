package com.ejercicios.ejercicio14;

import java.io.File;
import java.util.ArrayList;

public class Utilidades {
	private static ArrayList<Utilidades> titulo;

	// Por Gemini
	/**
	 * public static void contadorTitulo(String ruta) { File archivos = new
	 * File(ruta); File[] listaArchivos = archivos.listFiles();
	 * 
	 * if (listaArchivos != null) { for (File archivo : listaArchivos) { if
	 * (archivo.isFile()) { String nombreOriginal = archivo.getName(); String
	 * nombreFinal;
	 * 
	 * if (nombreOriginal.length() > 30) {
	 * 
	 * int posicionPunto = nombreOriginal.lastIndexOf('.');
	 * 
	 * String nombreSinExtension; String extension;
	 * 
	 * if (posicionPunto == -1) { nombreSinExtension = nombreOriginal; extension =
	 * ""; } else { nombreSinExtension = nombreOriginal.substring(0, posicionPunto);
	 * extension = nombreOriginal.substring(posicionPunto); }
	 * 
	 * int finCorte = 27; if (nombreSinExtension.length() < 27) { finCorte =
	 * nombreSinExtension.length(); }
	 * 
	 * nombreFinal = nombreSinExtension.substring(0, finCorte) + "..." + extension;
	 * 
	 * } else { nombreFinal = nombreOriginal; }
	 * 
	 * System.out.println(nombreFinal); } } } else { System.out.println("No se han
	 * encontrado archivos."); } }
	 **/

	// Por profe
	private static String acortarNombre(String nombreArchivo) {

		int puntoExtension;
		String nombre;
		String extension;
		int LONGITUD_MAXIMA = 30;

		if (nombreArchivo.length() <= LONGITUD_MAXIMA) {
			return nombreArchivo;
		}

		puntoExtension = nombreArchivo.lastIndexOf(".");

		if (puntoExtension == -1) {
			return nombreArchivo.substring(0, LONGITUD_MAXIMA - 3) + "...";
		}

		nombre = nombreArchivo.substring(0, puntoExtension);
		extension = nombreArchivo.substring(puntoExtension);

		if (nombre.length() > LONGITUD_MAXIMA - 3) {
			nombre = nombre.substring(0, LONGITUD_MAXIMA - 3);
		}

		return nombre + "..." + extension;
	}

	public static void mostrarContenido(String ruta) {

		File f = new File(ruta);
		File[] archivos;

		if (existe(ruta)) {
			System.out.printf("La ruta \"%s\" existe %n", ruta);
			System.out.printf("Permisos: %s %n", getPermisos(ruta));
			if (f.isFile()) {
				System.out.println("Es un fichero ");
				System.out.printf("Nombre: %s%n", f.getName());
				System.out.printf("Tamaño: %s%n", f.length());
			} else if (f.isDirectory()) {
				System.out.println("Es un directorio");
				archivos = f.listFiles();
				for (File archivo : archivos) {
					System.out.printf("\t%6s %30s %d bytes\n", getPermisos(archivo.getAbsolutePath()),
							archivo.getName(), archivo.length());
				}
			}

		} else {
			System.out.printf("La ruta \"%s\" no existe", ruta);
		}

	}

	private static boolean existe(String ruta) {

		return new File(ruta).exists();
	}

	private static String getPermisos(String ruta) {
		File f = new File(ruta);

		String permisos = "";

		permisos += f.isDirectory() ? "d" : "-";
		permisos += f.canRead() ? "r" : "-";
		permisos += f.canWrite() ? "w" : "-";
		permisos += f.canExecute() ? "x" : "-";

		return permisos;
	}

}

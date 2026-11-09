package com.ejercicios.ejercicio15;

import java.io.File;

public class Utilidades {
	public static void eliminarArchivos(String directorio, String extension) {

		File dir = new File(directorio);
		File[] archivos;

		if (dir.exists() && dir.isDirectory()) {
			archivos = dir.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isFile() && archivo.getName().endsWith("." + extension)) {
						if (archivo.delete()) {
							System.out.printf("No se pudo eliminar el archivo \"%s\"", archivo.getName());
						}
					}
				}
			} else {
				System.out.println("No se puede listar el contenido del directorio.");
			}
		} else {
			System.out.printf("El directorio \"%s\" no existe o no es un directorio\n ");
		}
	}
}

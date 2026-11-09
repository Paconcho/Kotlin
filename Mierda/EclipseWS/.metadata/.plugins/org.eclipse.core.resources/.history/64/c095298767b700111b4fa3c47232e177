package Trabajo;
	
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import Clases.Alumno;

public class App {
	public static void main(String[] args) throws IOException {
		ArrayList<Coche> coches = new ArrayList<>(); 	
		
		coches.add(new Coche("Wolkswagen", 110, 3));
		coches.add(new Coche("Peugeot", 60, 5));
		coches.add(new Coche("Skoda", 230, 3));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el modelo: ");
			String modelo = sc.nextLine();
		System.out.println("Introduce caballos: ");
			int caballos = sc.nextInt();
		System.out.println("Introduce nº puertas: ");
			int puertas = sc.nextInt();	
		
		sc.nextLine();
		String linea = modelo + ": " + caballos + ": " + puertas + "\n"; 
		Path ruta = Path.of("coches.txt");
		
		String texto = "";
		
		for(Coche c : coches) {
			if(c.getCaballos() < 100) {
			texto += c.getMarca() + ": " + c.getCaballos() + ", " + c.getPuertas(); 
			}
		}
		
		Files.writeString(ruta, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	}
}

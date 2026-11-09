package Files;

import java.nio.file.Path;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class App {
	
	final static String ruta = "D:\\damdu204\\EclipseWS\\AD\\src\\Files\\archivo.txt";
	
public static void main(String[] args) throws IOException {
	
//	try(BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))){
//		bw.write("Programacion");
//		bw.newLine();
//		bw.write("Base de Datos");
//		bw.newLine();
//		bw.write("Acceso a Datos");
//	}catch (IOException e) {
//		System.out.println("Error: " + e.getMessage());
//	}
	
	String texto = "Programacion ...";
	Files.writeString(Path.of("asignaturas.txt"), texto);
	
	}
}


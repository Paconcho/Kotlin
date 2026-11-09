package com.ejercicios.ejercicio07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ejercicios.ejercicio03.Operativa;

public class operativa {
	private static final String RUTA = "datosNombresPesos.dat";
		
		/**
		 * Empleamos try-with-resources
		 * @param vector
		 */
		
		public static void leerPersonas() {
			
			HashMap<String, Double> personas = new HashMap();
			
			try(DataInputStream entrada = new DataInputStream(new FileInputStream(RUTA))) {
				while(entrada.available() > 0) {
					personas.put(entrada.readUTF(), entrada.readDouble());
				}
			}catch (Exception e){
					System.out.println("Error: " + e.getMessage());
				}
				
				if(!personas.isEmpty()) {
				for (Map.Entry<String, Double> entry : personas.entrySet()) {
					
					System.out.printf("%s: ", entry.getKey());
					System.out.printf("%.2f %n", entry.getValue()); 
				}
			}	
		}		
}


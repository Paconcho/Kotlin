package com.ejercicios.ejercicio06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutput;
import java.io.DataOutputStream;
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
		
		public static void escribirNombresPesos() {
			
			HashMap<String, Double> personas = new HashMap();
			personas.put("Julio", 80.0);
			personas.put("Xan", 78.8);
			personas.put("Luis", 70.0);
			personas.put("Claudia", 38.6);
			personas.put("Angela", 5.1);
			
			try(DataOutputStream salida = new DataOutputStream(new FileOutputStream(RUTA))) {
				for (Map.Entry<String, Double> entry : personas.entrySet()) {
					salida.writeUTF(entry.getKey());
					salida.writeDouble(entry.getValue());
				}
				
				
//				  *Es lo mismo que arriba*
//				 
//				  for(String nombre : personas.keySet()) {
//				
//					personas.get(nombre);
//				}
				
				
			}catch (Exception e){
				System.out.println("Error: " + e.getMessage());
			}
			
			
			
  }
}

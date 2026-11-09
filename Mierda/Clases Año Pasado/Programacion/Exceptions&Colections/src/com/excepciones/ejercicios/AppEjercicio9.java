package com.excepciones.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppEjercicio9 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Ejercicio9_CuentaBancaria cuenta = new Ejercicio9_CuentaBancaria("Pepe", 1200);
		
		try {
			System.out.println("Introduce cantidad a retirar: ");
				int cantidad = sc.nextInt();
				
			cuenta.retirar(cantidad);
			
			System.out.println("Operacion realizada con exito. El nuevo saldo es de: " + cuenta.getSaldo());
			
		}catch(InputMismatchException e){
			System.out.println("Error: " + e.getMessage());
		}catch(Ejercicio9_CantidadInvalidaException | Ejercicio9_SaldoInsuficienteException e) {
			System.out.println("Error: " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

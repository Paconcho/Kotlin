package com.excepciones.ejercicios;

public class Ejercicio7 {
	public static void provocarStackOverflow() {
        provocarStackOverflow();
    }

    public static void main(String[] args) {
        try {
            provocarStackOverflow(); 
            int[] arrayXigante = new int[Integer.MAX_VALUE]; 
        } catch (StackOverflowError e) {
            System.out.println("Capturado Erro: Desbordamento da pila (Stack Overflow).");
        } catch (OutOfMemoryError e) {
            System.out.println("Capturado Erro: Quedamos sen memoria RAM (Out of Memory).");
        }
    }
}

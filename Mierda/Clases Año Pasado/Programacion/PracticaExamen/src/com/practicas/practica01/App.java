package com.practicas.practica01;

import java.util.ArrayList;
import java.util.Collections;

public class App {
	public static void main(String[] args) {

		ArrayList<Integer> listaNumeros = new ArrayList();
		ArrayList<Integer> listaPares = new ArrayList();
		cargarNumerosPrueba(listaNumeros);

		listaPares = filtrarPares(listaNumeros);
		System.out.println(listaPares);

		Collections.sort(listaPares);

		for (Integer num : listaPares) {
			System.out.println(num);
		}

	}

	private static int sumar(ArrayList<Integer> listaPares) {
		int sumatorio = 0;
		for (Integer numero : listaPares) {
			sumatorio += numero;
		}
		return sumatorio;
	}

	private static ArrayList<Integer> filtrarPares(ArrayList<Integer> listaNumeros) {
		ArrayList<Integer> l = new ArrayList();

		for (Integer numero : listaNumeros) {
			if (numero % 2 == 0) {
				l.add(numero);

			}
		}
		return l;
	}

	private static void cargarNumerosPrueba(ArrayList<Integer> listaNumeros) {

		listaNumeros.add(15);
		listaNumeros.add(21);
		listaNumeros.add(-8);
		listaNumeros.add(6);
		listaNumeros.add(5);
		listaNumeros.add(2);

	}
}

package com.excepciones.ejercicios;

public class Ejercicio9_CuentaBancaria {
	int saldo;
	String propietario;

	public Ejercicio9_CuentaBancaria(String propietario, int saldo) {
		super();
		this.saldo = saldo;
		this.propietario = propietario;
	}
	
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double cantidad) throws Ejercicio9_CantidadInvalidaException{
		if(cantidad < 0) {
			throw new Ejercicio9_CantidadInvalidaException("No se puede retirar una cantidad negativa");
		}
		this.saldo += cantidad;
	}
	
	public void retirar(double cantidad) throws Ejercicio9_SaldoInsuficienteException, Ejercicio9_CantidadInvalidaException{
		if(cantidad < 0) {
			throw new Ejercicio9_SaldoInsuficienteException("No se puede introducir una cantidad negativa");
		}
		if(cantidad > saldo) {
			throw new Ejercicio9_CantidadInvalidaException("Saldo insuficiente");
		}
		this.saldo -= cantidad;
	}
}

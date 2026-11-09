package Trabajo;

public class Coche {
	String marca;
	int caballos;
	int puertas;

	public Coche(String marca, int caballos, int puertas) {
		super();
		this.marca = marca;
		this.caballos = caballos;
		this.puertas = puertas;
	}

	public Coche() {
		super();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + ", Nº caballos: " + caballos + ", Numero de puertas:" + puertas + "";
	}
}

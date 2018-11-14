package com.prieto;

import java.util.Arrays;

public class TeoremaDelPuntoFijo_324 {
	static java.util.Scanner sc;
	static int[] vectorInicial;
	static String[] vectorDeCambios;

	static void inicializarVectores(short n) {
		vectorInicial = new int[n];
		for (int i = 0; i < n; i++) {
			vectorInicial[i] = i;
		}
		vectorDeCambios = sc.nextLine().split(" ");
	}

	static int[] mover(int[] vector) {

		int[] vectorTemp = new int[vector.length];
		for (int i = 0; i < vector.length; i++) {
			vectorTemp[Integer.parseInt(vectorDeCambios[i]) - 1] = vector[i];
		}

		return vectorTemp;
	}

	public static void casosdeprueba(short n) {
		inicializarVectores(n);
		int[] vectorMovido = new int[n];
		vectorMovido = vectorInicial;
		boolean iguales = false;
		int cont = 0;
		while (!iguales) {
			vectorMovido = mover(vectorMovido);
			iguales = Arrays.equals(vectorInicial, vectorMovido);
			cont++;
		}
		System.out.println(cont);
	}

	public static void main(String[] args) {

		sc = new java.util.Scanner(System.in);
		short moleculas = Short.parseShort(sc.nextLine());
		while (moleculas >= 1 && moleculas <= 100) {
			casosdeprueba(moleculas);
			moleculas = Short.parseShort(sc.nextLine());
			if (moleculas == 0) {
				break;
			}
		}
		sc.close();
		System.exit(0);
	}

}

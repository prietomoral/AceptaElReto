package com.prieto;

import java.util.Scanner;

public class InternetEnElMetro {

	public static void main(String[] args) {

		String[] entrada;
		System.out.println("Numero de casos");
		Scanner sc = new Scanner(System.in);

		int numCasos = Integer.valueOf(sc.nextLine());

		for (int prueba = 0; prueba < numCasos; prueba++) {
			System.out.println("Longitud del tunel y Numero de Antenas:");
			entrada = sc.nextLine().split(" ");
			System.out.println("Longitud Tunel:" + entrada[0]);
			System.out.println("Numero de Antenas:" + entrada[1]);

			String[] arrayAntenas = new String[Integer.valueOf(entrada[1])];
			System.out.println("Por cada antena: longitug al inicio y cobertura");
			arrayAntenas = sc.nextLine().split(" ");
			int coberMax = 0;

			// buscamos que alguna antena cubra la parte inicial del tunel
			int i = 0;
			while (i < arrayAntenas.length - 1) {
				if (Integer.valueOf(arrayAntenas[i]) - Integer.valueOf(arrayAntenas[i + 1]) <= coberMax) {
					coberMax = Integer.valueOf(arrayAntenas[i + 1]) + Integer.valueOf(arrayAntenas[i]);
				}
				i = i + 2;
			}

			if (coberMax >= Integer.valueOf(entrada[0]))
				System.out.println("SI");
			else
				System.out.println("NO");

		} // for casos

		sc.close();
		System.exit(0);
	}

}

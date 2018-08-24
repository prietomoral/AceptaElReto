package com.prieto;

import java.util.Scanner;

public class InternetEnElMetro {

	public static void main(String[] args) {

		String[] entrada;
		System.out.println("Numero de casos");
		Scanner sc = new Scanner(System.in);

		int numCasos = Integer.valueOf(sc.nextLine());

		for (int prueba = 0; prueba < numCasos; prueba++) {
			System.out.println("Longitud del tunel y Numero de Antenas");
			entrada = sc.nextLine().split(" ");
			System.out.println("Longitud Tunel:" + entrada[0]);
			System.out.println("Numero de Antenas:" + entrada[1]);

			String[] antenasDistanciaCobertura = new String[Integer.valueOf(entrada[1])];
			System.out.println("Lonitud y Distancias");
			antenasDistanciaCobertura = sc.nextLine().split(" ");
			boolean coberMin = false;
			int coberMax = 0;
			for (int i = 0; i < antenasDistanciaCobertura.length; i = i + 2) {
				// Distancia mayor que la cobertura --> mirar otra antena
				if (!coberMin && Integer.valueOf(antenasDistanciaCobertura[0])
						- Integer.valueOf(antenasDistanciaCobertura[1]) > 0) {
					continue;
				} else {
					coberMin = true;
					coberMax = Integer.valueOf(antenasDistanciaCobertura[0])
							+ Integer.valueOf(antenasDistanciaCobertura[1]);
				}
				
				System.out.println(antenasDistanciaCobertura[i]);
			}

		}

		sc.close();
		System.exit(0);
	}

}

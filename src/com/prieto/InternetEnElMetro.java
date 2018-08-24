package com.prieto;

import java.util.Scanner;

public class InternetEnElMetro {

	public static void main(String[] args) {
		
		String[] entrada;
		System.out.println("Numero de casos");
		Scanner sc = new Scanner(System.in);
		
		int numCasos = Integer.valueOf(sc.nextLine());
		
		for (int prueba = 0; prueba < numCasos; prueba++ ){
			entrada = sc.nextLine().split(" ");
			System.out.println("Longitud Tunel:" + entrada[0]);
			System.out.println("Numero de Antenas:" + entrada[1]);
		}
		
		sc.close();
		System.exit(0);
	}

}

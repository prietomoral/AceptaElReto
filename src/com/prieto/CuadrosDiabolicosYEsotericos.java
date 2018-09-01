package com.prieto;

public class CuadrosDiabolicosYEsotericos {
	static java.util.Scanner sc;
	static int matriz[][] = null;

	private static void llenarMatriz(int n) {
		matriz = new int[n][n];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = sc.nextInt();// EL OBJETO DE TIPO SCANNER LEE
			}
		}
	}

	public static void main(String[] args) {
		sc = new java.util.Scanner(System.in);
		int n = sc.nextInt();

		while (n != 0) {
			llenarMatriz(n);

			n = sc.nextInt();
		}

		sc.close();
		System.exit(0);
	}

}

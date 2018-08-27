package com.prieto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Kaprekar_100 {
	static java.util.Scanner sc;
	static final int KAPREKAR = 6174;

	public static boolean repdigits(char[] arrayN) {
		return arrayN[0] == arrayN[1] && arrayN[1] == arrayN[2] && arrayN[2] == arrayN[3];
	}

	private static char[] formarNumero(String cifras) {
		cifras = "0000" + cifras;
		return cifras.substring(cifras.length() - 4).toCharArray();
	}

	private static int obtenerMayor(char[] cifras) {
		StringBuffer sb = new StringBuffer(String.valueOf(cifras));
		return Integer.valueOf(sb.reverse().toString());
	}

	public static void casosdeprueba() {
		int n = sc.nextInt();
		if (n == KAPREKAR)
			System.out.println("0");
		else {
			char[] entrada = formarNumero(String.valueOf(n));
			if (repdigits(entrada))
				System.out.println("8");
			else {
				int vueltas = 0;

				while (n != KAPREKAR) {
					Arrays.sort(entrada);
					n = obtenerMayor(entrada) - Integer.valueOf(String.valueOf(entrada));
					entrada = formarNumero(String.valueOf(n));
					vueltas++;
				}
				System.out.println(vueltas);
			}
		}
	}

	public static void main(String[] args) {
		sc = new java.util.Scanner(System.in);
		int numcasos = sc.nextInt();
		for (int i = 0; i < numcasos; i++) {
			casosdeprueba();
		}
		sc.close();
		System.exit(0);
	}

}

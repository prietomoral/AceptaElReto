package com.prieto;

public class InternetMetro {
	static java.util.Scanner sc;

	public static void casosdeprueba() {
//		System.out.println("Longitud del tunel y Numero de Antenas:");
		String[] entrada = sc.nextLine().split(" ");
//		System.out.println("Longitud Tunel:" + entrada[0]);
//		System.out.println("Numero de Antenas:" + entrada[1]);
		int longitudTunel = Integer.valueOf(entrada[0]);
		int numAntenas = Integer.valueOf(entrada[1]);
		entrada = new String[Integer.valueOf(entrada[1])];
//		System.out.println("Por cada antena: posicion y cobertura: ");
		entrada = sc.nextLine().split(" ");
		int coberMax = 0;

		int i = 0;
		while (i < numAntenas * 2) {
			if (Integer.valueOf(entrada[i]) - Integer.valueOf(entrada[i + 1]) <= coberMax
					&& coberMax < Integer.valueOf(entrada[i + 1]) + Integer.valueOf(entrada[i])) {
				coberMax = Integer.valueOf(entrada[i + 1]) + Integer.valueOf(entrada[i]);
			}
			i = i + 2;
		}

		if (coberMax >= longitudTunel)
			System.out.println("SI");
		else
			System.out.println("NO");
	}

	public static void main(String[] args) {
		sc = new java.util.Scanner(System.in);
		int numcasos = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numcasos; i++) {
			casosdeprueba();
		}
		sc.close();
		System.exit(0);
	}

}

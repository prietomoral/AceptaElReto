package com.prieto;

public class InternetMetro {
	static java.util.Scanner sc;

	public static void casosdeprueba() {
		String[] entrada = new String[2];
		entrada = sc.nextLine().split(" ");
		int longitudTunel = Integer.valueOf(entrada[0]);
//		int numAntenas = Integer.valueOf(entrada[1]);
//		entrada = new String[Integer.valueOf(entrada[1])];
		entrada = sc.nextLine().split(" ");
		int coberMax = 0;

		int i = 0;
		while (i < entrada.length) {
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

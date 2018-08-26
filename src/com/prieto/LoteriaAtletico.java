package com.prieto;

public class LoteriaAtletico {
	static java.util.Scanner sc;

	public static void casosdeprueba() {
		int numDecimos = sc.nextInt();
		String[] decimos = new String [numDecimos];
		int cont = 0;
		if (numDecimos > 0 && numDecimos <= 10000) {
			sc.nextLine();
			decimos = sc.nextLine().split(" ");
			for (int i = 0; i < decimos.length; i++) {
				if (Integer.valueOf(decimos[i]) % 2 == 0 && Integer.valueOf(decimos[i]) >= 0 && Integer.valueOf(decimos[i]) <= 99999)
					cont++;

			}
		}
		System.out.println(cont);
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

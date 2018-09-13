package com.prieto;

public class Moviles {
	static java.util.Scanner sc;

	public static boolean esBalenceado(int pi, int di, int pd, int dd) {
		String[] entrada;
		boolean izda = true;
		if (pi == 0) {
			entrada = sc.nextLine().split(" ");

			izda = esBalenceado(Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]),
					Integer.parseInt(entrada[2]), Integer.parseInt(entrada[3]));
		}

		boolean dcha = true;
		if (pd == 0) {
			entrada = sc.nextLine().split(" ");
			dcha = esBalenceado(Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]),
					Integer.parseInt(entrada[2]), Integer.parseInt(entrada[3]));
		}

		return izda && dcha && pi * di == pd * dd;
	}

	public static void main(String[] args) {

		sc = new java.util.Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		boolean balancea;
		while (!(entrada[0].equals("0") && entrada[1].equals("0") && entrada[2].equals("0")
				&& entrada[3].equals("0"))) {
			balancea = esBalenceado(Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]),
					Integer.parseInt(entrada[2]), Integer.parseInt(entrada[3]));

			if (balancea) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}

			entrada = sc.nextLine().split(" ");
		}
		sc.close();
		System.exit(0);
	}

}

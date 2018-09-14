package com.prieto;

public class Moviles {
	static java.util.Scanner sc;

	static int pesoIzdo = 0;

	static int pesoDcho = 0;

	public static boolean esBalenceado(int pi, int di, int pd, int dd, int[] p) {
		String[] entrada;
		boolean izda = true;
		if (pi == 0) {
			entrada = sc.nextLine().split(" ");
			int ipi = Integer.parseInt(entrada[0]);
			int idi = Integer.parseInt(entrada[1]);
			int ipd = Integer.parseInt(entrada[2]);
			int idd = Integer.parseInt(entrada[3]);
			p[0] = pi;
			izda = esBalenceado(ipi, idi, ipd, idd, p);
			if (pi == 0)
				pesoIzdo = ipi + ipd;
		}

		boolean dcha = true;
		if (pd == 0) {
			entrada = sc.nextLine().split(" ");
			int dpi = Integer.parseInt(entrada[0]);
			int ddi = Integer.parseInt(entrada[1]);
			int dpd = Integer.parseInt(entrada[2]);
			int ddd = Integer.parseInt(entrada[3]);
			p[1] = pd;

			dcha = esBalenceado(dpi, ddi, dpd, ddd, p);
			if (pd == 0)
				pesoDcho = dpi + dpd;
		}

		// p[0] = pi + pd;
		if (pi == 0) {
			pi = pesoIzdo;
		}
		if (pd == 0) {
			pd = pesoDcho;
		}
		return izda && dcha && pi * di == pd * dd;
	}

	public static void main(String[] args) {

		sc = new java.util.Scanner(System.in);
		int[] peso = new int[2];
		String[] entrada = sc.nextLine().split(" ");
		boolean balancea;
		while (!(entrada[0].equals("0") && entrada[1].equals("0") && entrada[2].equals("0")
				&& entrada[3].equals("0"))) {
			balancea = esBalenceado(Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]),
					Integer.parseInt(entrada[2]), Integer.parseInt(entrada[3]), peso);

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

package com.prieto;

public class FiestaVerano {
	static java.util.Scanner sc;

	public static void casosdeprueba(String entrada) {
		String[] tramosEdad = entrada.split(" ");
		long tramoEdadMinimo = 0;
		long numTramosEdad = tramosEdad.length - 1;
		if (numTramosEdad > 0)
			tramoEdadMinimo = Long.parseLong(tramosEdad[0]);
		long totalPersonas = 0;

		// ObtenemosTramoMenor
		for (int i = 0; i < tramosEdad.length - 1; i++) {
			if (Long.parseLong(tramosEdad[i]) < tramoEdadMinimo)
				tramoEdadMinimo = Long.parseLong(tramosEdad[i]);

			totalPersonas = totalPersonas + Long.parseLong(tramosEdad[i]);
		}
		
		boolean enc = false;
		for (long i = tramoEdadMinimo; i >= 1 && !enc; i--) {
			for (int j = 0; j < tramosEdad.length - 1; j++) {
				if (Long.parseLong(tramosEdad[j]) % i != 0) {
					break;
				} else if (j == tramosEdad.length - 2) {
					System.out.println(totalPersonas / i);
					enc = true;
				}

			}
		}

	}

	public static void main(String[] args) {

		sc = new java.util.Scanner(System.in);
		String entrada = sc.nextLine();

		while (!entrada.equals("0")) {
			casosdeprueba(entrada);
			entrada = sc.nextLine();
		}
		sc.close();
		System.exit(0);
	}

}

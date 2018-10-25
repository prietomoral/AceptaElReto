package com.prieto.accepted;


public class AproximaxionDeGauss_107 {
	static java.util.Scanner sc;
	static double[] erroresPermitidos = { 1, 0.1, 0.01, 0.001, 0.0001, 0.00001 };
	static Integer [] primos = new Integer [100005];
	
	public static void casosdeprueba(int n, int m) {
		if (m == 1) {
			System.out.println("Menor");
		} else {
		    double numPrimos;
			// numPrimos = numeroDePrimos(n);
			numPrimos = primos[n];

			double errorGauss = Math
					.abs((double) (numPrimos / (double) n) - (double) ((double) 1 / (double) Math.log(n)));

			double errorPermitido = erroresPermitidos[m]; // (double) 1 / (double) Math.pow(10, m);

			if (errorGauss > errorPermitido) {
				System.out.println("Mayor");
			} else if (errorGauss < errorPermitido) {
				System.out.println("Menor");
			} else {
				System.out.println("Igual");
			}
		}
	}

	static boolean es_primo(int p) {
		if (p == 1)
			return false; // 1 no es primo
		if (p == 2)
			return true; // 2 es primo
		if (p % 2 == 0)
			return false; // no es primo ning�n par, excepto el 2
		double raiz = Math.sqrt(p);
		for (long i = 3; i <= raiz; i += 2) {
			if (p % i == 0)
				return false;
		}
		return true;
	}

	static int numeroDePrimos(int n) {
		int i, j;
		boolean esPrimo;
		int rInicial = 2;// Rango inicial, este debe ser mayor de 1.
		int rFinal = n;// Rango final.
		int cont = 0;
		for (i = rInicial; i <= rFinal; i++) {
			// recorro ciclo tantas veces como necesite(<= es para incluir el valor de
			// rFinal).
//			esPrimo = true;
//			for (j = 2; j < i && esPrimo; j++) {
//				// no coloque j = 1 porque ya sabemos que todo numero es divisible por 1.
//				/*
//				 * j < i es para no incluir el numero a evaluar, pues todo numero es divisible
//				 * por si mismo.
//				 */
//				if (i % j == 0) {// Si además del 1 y el mismo hay otro divisor, ya no es primo.
//					esPrimo = false;
//				}
//			}

			esPrimo = es_primo(i);
			if (esPrimo) {
				cont++;
			}
		}
		return cont;
	}

	static void inicializarPrimos() {
        int i;
        boolean esPrimo;
        int rInicial = 2;// Rango inicial, este debe ser mayor de 1.
        primos[0]=0;
        primos[1]=0;
        int rFinal = 100001;// Rango final.
        int cont = 0;
        for (i = rInicial; i <= rFinal; i++) {
            esPrimo = es_primo(i);
            if (esPrimo) {
                cont++;
            }
            primos[i]=cont;
        }
    }

	
	public static void main(String[] args) {

		sc = new java.util.Scanner(System.in);
        inicializarPrimos();
		String[] entrada = sc.nextLine().split(" ");
		int n = Integer.parseInt(entrada[0]);
		int m = Integer.parseInt(entrada[1]);
		while (!(n == 0 && m == 0)) {
			casosdeprueba(n, m);
			entrada = sc.nextLine().split(" ");
			n = Integer.parseInt(entrada[0]);
			m = Integer.parseInt(entrada[1]);
		}
		sc.close();
		System.exit(0);
	}

}

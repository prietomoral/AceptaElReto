package com.prieto;

public class AproximaxionDeGauss_107 {
    static java.util.Scanner sc;

    public static void casosdeprueba(int n, int m) {
        double numPrimos = numeroDePrimos(n);

        double errorGauss = Math.abs((double) (numPrimos / (double) n) - (double) ((double) 1 / (double) Math.log(n)));

        double errorPermitido = (double) 1 / (double) Math.pow(10, m);

        if (errorGauss > errorPermitido) {
            System.out.println("Mayor");
        } else if (errorGauss < errorPermitido) {
            System.out.println("Menor");
        } else {
            System.out.println("Igual");
        }
    }

    static int numeroDePrimos(int n) {
        int i, j;
        boolean esPrimo;
        int rInicial = 2;// Rango inicial, este debe ser mayor de 1.
        int rFinal = n;// Rango final.
        int cont = 0;
        for (i = rInicial; i <= rFinal; i++) {
            // recorro ciclo tantas veces como necesite(<= es para incluir el valor de rFinal).
            esPrimo = true;
            for (j = 2; j < i && esPrimo; j++) {
                // no coloque j = 1 porque ya sabemos que todo numero es divisible por 1.
                /* j < i es para no incluir el numero a evaluar, pues todo numero es divisible por si mismo. */
                if (i % j == 0) {// Si además del 1 y el mismo hay otro divisor, ya no es primo.
                    esPrimo = false;
                }
            }
            if (esPrimo) {// Si es primo lo imprimo.
                cont++;
            }
        }
        return cont;
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        while (!(entrada[0].equals("0") && entrada[1].equals("0"))) {
            casosdeprueba(Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]));
            entrada = sc.nextLine().split(" ");
        }
        sc.close();
        System.exit(0);
    }

}

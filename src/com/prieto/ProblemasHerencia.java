package com.prieto;

public class ProblemasHerencia {
    static java.util.Scanner sc;

    static int[] polinomio = new int[21];

    static int n;

    public static double f(double num) {
        double valor = 0;
        for (int i = 0; i <= n; i++) {
            valor = valor + (polinomio[i] * Math.pow(num,(double) i));
        }
        if (valor < 0)
            return 0;
        else if (valor > 1)
            return 1;
        return valor;

    }

    public static void casosdeprueba() {

        String[] entrada = sc.nextLine().split(" ");
        int numReptangulos = Integer.parseInt(sc.nextLine());

        int aux = n;
        // Creamos el polinomio
        for (int i = 0; i < entrada.length; i++) {
            polinomio[aux] = Integer.parseInt(entrada[i]);
            aux--;
        }

        double base = (double)1 / numReptangulos;
        double areaCain = 0;
        double altura = 0;
        for (int i = 0; i < numReptangulos; i++) {
            altura = f(i) / numReptangulos;
            areaCain = areaCain + (base * altura);
        }

        if (Math.abs(areaCain - 0.5) <= 0.001)
            System.out.println("JUSTO");
        else if (areaCain > 0.5)
            System.out.println("CAIN");
        else
            System.out.println("ABEL");
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        while (n != 20) {
            casosdeprueba();
            n = Integer.parseInt(sc.nextLine());
        }

        sc.close();
        System.exit(0);
    }

}

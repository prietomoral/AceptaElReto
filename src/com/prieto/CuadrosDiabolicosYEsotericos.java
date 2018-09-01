package com.prieto;

import java.util.Arrays;

public class CuadrosDiabolicosYEsotericos {
    static java.util.Scanner sc;

    static int matriz[][] = null;

    static int cm = 0;

    static int cm2 = 0;

    static int[] vector = null; // la usare para validar la condicion 1 - esoterico

    private static void llenarMatriz(int n) {
        matriz = new int[n][n];
        vector = new int[n * n];
        int k = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = sc.nextInt();
                vector[k] = matriz[i][j];
                k++;
            }

        }
    }

    private static void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void cmycm2(int n) {
        for (int i = 0; i < n; i++) {
            cm = cm + matriz[0][i];
        }
        cm2 = (4 * cm) / n;

        System.out.println(cm);
        System.out.println(cm2);
    }

    private static boolean diabolico() {
        int totalFila = 0;
        int totalCol = 0;
        int diagonal = 0;
        int diagonalInversa = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    diagonal = diagonal + matriz[i][j];
                }
                if (i + j == matriz.length - 1) {
                    diagonalInversa = diagonalInversa + matriz[i][j];
                }
                totalFila = totalFila + matriz[i][j];
                totalCol = totalCol + matriz[j][i];
            }
            if (totalFila != cm || totalCol != cm) {
                return false;
            }
            totalFila = 0;
            totalCol = 0;
        }

        return (diagonal == cm && diagonalInversa == cm);
    }

    private static boolean esoterico(int n) {
        // condicion 1 - contiene todos los numero de 1 a n*n
        Arrays.sort(vector);
        for (short numero = 1; numero <= n*n; numero++){
            if (numero != vector[numero - 1]) 
                return false;
        }

        // condicion 2 - suma de sus esquinas igual a cm2
        int esquinas = (matriz[0][0] + matriz[n - 1][0] + matriz[0][n - 1] + matriz[n - 1][n - 1]);
        if (esquinas != cm2) {
            return false;
        }
        // condicion 3 n es impar
        if (n % 2 != 0) {
            // suma de la mitad de los laterales es cm2 y la casilla central tambien
            int mitadLaterales = (matriz[0][n / 2] + matriz[n / 2][0] + matriz[n / 2][n - 1] + matriz[n - 1][n / 2]);
            int central = (matriz[n / 2][n / 2]) * 4;
            return (mitadLaterales == cm2 && central == cm2);
        } else
        // condicion 4 n es par
        {
            // suma de la mitad de las 2 casillas laterales es 2*cm2 y las 4 casillas centrales tambien
            int mitadesLaterales = (matriz[0][n / 2] + matriz[0][n / 2 - 1] + matriz[n / 2][0] + matriz[n / 2 - 1][0] + matriz[n / 2][n - 1]
                    + matriz[n / 2 - 1][n - 1] + matriz[n - 1][n / 2] + matriz[n - 1][n / 2 - 1]);
            int centrales = (matriz[n / 2][n / 2] + matriz[n / 2 - 1][n / 2 - 1] + matriz[n / 2 - 1][n / 2] + matriz[n / 2][n / 2 - 1]);
            return (mitadesLaterales == 2 * cm2 && centrales == cm2);
        }

    }

    public static void main(String[] args) {
        sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();

        while (n != 0) {
            llenarMatriz(n);
            imprimirMatriz();
            cmycm2(n);
            if (diabolico()) {
                if (esoterico(n))
                    System.out.println("ESOTERICO");
                else
                    System.out.println("DIABOLICO");
            } else {
                System.out.println("NO");
            }

            cm = 0;
            cm2 = 0;
            n = sc.nextInt();
        }

        sc.close();
        System.exit(0);
    }

}

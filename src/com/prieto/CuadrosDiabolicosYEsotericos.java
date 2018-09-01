package com.prieto;

public class CuadrosDiabolicosYEsotericos {
    static java.util.Scanner sc;

    static int matriz[][] = null;

    static int cm = 0;

    static int cm2 = 0;

    private static void llenarMatriz(int n) {
        matriz = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = sc.nextInt();
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
                if (i+j == matriz.length-1) {
                    diagonalInversa = diagonalInversa + matriz[i][j];
                }
                totalFila = totalFila + matriz[i][j];
                totalCol = totalCol +  matriz[j][i];
            }
            if (totalFila != cm || totalCol != cm) {
                return false;
            }
            totalFila = 0;
            totalCol=0;
        }
        
        
        return (diagonal == cm && diagonalInversa==cm);
    }

    private static boolean esoterico() {
        return false;
    }

    public static void main(String[] args) {
        sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();

        while (n != 0) {
            llenarMatriz(n);
            imprimirMatriz();
            cmycm2(n);
            if (diabolico()) {
                if (esoterico())
                    System.out.println("ESOTERICO");
                else
                    System.out.println("DIABOLICO");
            } else {
                System.out.println("NO");
            }
           

            n = sc.nextInt();
        }

        sc.close();
        System.exit(0);
    }

}

package com.prieto.accepted;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Anio2013_174 {
    static java.util.Scanner sc;

    static boolean tieneRepetidos(int num) {
        int[] cont = new int[10];
        int digito;
        while (num > 0) {
            digito = (int) (num % 10);
            cont[digito]++;
            if (cont[digito] > 1) {
                return true;
            }
            num /= 10;
        }

        return false;
    }

    static int rango(int numero, boolean repetido, String limite) {
        while (tieneRepetidos(numero) == repetido) {
            if (limite.equals("inicial")) {
                numero--;
            } else if (limite.equals("final")) {
                numero++;
            }
        }
        return numero;
    }

    public static void casosdeprueba() {
        int anio = sc.nextInt();
        boolean repetido = tieneRepetidos(anio);
        int rangoInicio = rango(anio, repetido, "inicial");
        int rangoFin = rango(anio, repetido, "final");
        int primerAnio = rangoInicio + 1;
        int rango = rangoFin - primerAnio;
        System.out.println(primerAnio + " " + rango);

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

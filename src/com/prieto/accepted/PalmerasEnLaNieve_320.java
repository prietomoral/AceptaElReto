package com.prieto.accepted;

public class PalmerasEnLaNieve_320 {
    static java.util.Scanner sc;

    static boolean[] paseo;

    static int[] franja;

    static final int DEBILIDAD = 5;

    static void inicializarPaseo(int pesoTotal, int palmerasTotales) {
        paseo = new boolean[palmerasTotales];
        int pesoPalmera = 0;
        for (int i = 0; i < paseo.length; i++) {
            pesoPalmera = sc.nextInt();
            if (pesoPalmera < pesoTotal) {
                paseo[i] = false;
            } else {
                paseo[i] = true;
            }
        }
        sc.nextLine();
    }

    static int obtenerLongitud(int pos) {
        int contPalmeras = 0;
        int longitud = 0;
        while (pos < paseo.length && contPalmeras < DEBILIDAD) {
            if (paseo[pos]) {
                contPalmeras++;
            }
            longitud++;
            pos++;
        }
        return longitud;
    }

    public static void casosdeprueba2() {
        int pesoTotal = Integer.parseInt(sc.nextLine());
        int palmerasTotales = Integer.parseInt(sc.nextLine());
        inicializarPaseo(pesoTotal, palmerasTotales);
        int longitudMaxima = 0;
        int longitud;
        for (int i = 0; i < paseo.length; i++) {
            if (!paseo[i]) {
                longitud = obtenerLongitud(i);
                if (longitud == palmerasTotales) {
                    longitudMaxima = longitud;
                    break;
                } else if (longitud > longitudMaxima) {
                    longitudMaxima = longitud;
                }
            }
        }
        System.out.println(longitudMaxima);
    }

    public static void casosdeprueba() {
        int pesoTotal = Integer.parseInt(sc.nextLine());
        int palmeras = Integer.parseInt(sc.nextLine());
        franja = new int[palmeras];
        int i = 0;
        int j = 0;
        int l = 0;
        int enPie = 0;

        while (palmeras-- >0) {
            franja[j] = sc.nextInt();
            if (franja[j] >= pesoTotal && ++enPie > DEBILIDAD) {
                while (enPie > DEBILIDAD) {
                    if (franja[i] >= pesoTotal) {
                        enPie--;
                    }
                    i++;
                }

            }
            l = Math.max(l, j - i + 1);
            j++;
        }
        System.out.println(l);
        sc.nextLine();
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        int numcasos = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numcasos; i++) {
            casosdeprueba();
        }
        sc.close();
        System.exit(0);
    }

}

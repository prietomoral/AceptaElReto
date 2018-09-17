package com.prieto;

public class RatonesColoraos_398 {
    static java.util.Scanner sc;

    public static int obtenerTiempo(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }

    public static void casosdeprueba(String entrada) {
        String[] posiciones = new String[2];
        posiciones = entrada.split(" ");
        int F = Integer.parseInt(posiciones[0]);
        int C = Integer.parseInt(posiciones[1]);
        int SALIDA = 1;
        int N = sc.nextInt();

        int[] posObjetivo = new int[1];
        int[] posInicial = {1, 1};
        int[] posFinal = {F, C};
        int[] posRaton1 = {1, 1};
        int[] posRaton2 = {1, 1};
        int segRaton1;
        int segRaton2;
        int segTotales = 0;
        int segPosInicialObjetivo;
        while (N > 0) {
            posiciones = sc.nextLine().split(" ");
            posObjetivo[0] = Integer.parseInt(posiciones[0]);
            posObjetivo[1] = Integer.parseInt(posiciones[1]);
            segRaton1 = obtenerTiempo(posRaton1, posObjetivo);
            segRaton2 = obtenerTiempo(posRaton2, posObjetivo);
            segPosInicialObjetivo = obtenerTiempo(posInicial, posObjetivo);
            if (segRaton1 <= segRaton2) {
                if (segPosInicialObjetivo > segTotales) {
                    segTotales = segTotales + segRaton1;
                }
                posRaton1 = posObjetivo;
            } else {
                if (segPosInicialObjetivo > segTotales) {
                    segTotales = segTotales + segRaton2;
                }
                posRaton2 = posObjetivo;
            }
            N--;
        }

        // Falta calcular el tiempo maximo que les queda hasta el final
        int tiempoFinal = Math.max(obtenerTiempo(posRaton1, posFinal), obtenerTiempo(posRaton2, posFinal));
        segTotales = segTotales + tiempoFinal + SALIDA;
        System.out.println(segTotales);

    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        String entrada = sc.nextLine();
        while (!entrada.equals("")) {
            casosdeprueba(entrada);
        }
        sc.close();
        System.exit(0);
    }

}

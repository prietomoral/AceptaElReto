package com.prieto.accepted;

public class Moviles_104 {
    static java.util.Scanner sc;

    public static boolean esBalenceado(int[] movil) {
        String[] entrada;
        int pi = movil[0];
        int di = movil[1];
        int pd = movil[2];
        int dd = movil[3];
        boolean izda = true;
        if (pi == 0) {
            entrada = sc.nextLine().split(" ");
            movil[0] = Integer.parseInt(entrada[0]);
            movil[1] = Integer.parseInt(entrada[1]);
            movil[2] = Integer.parseInt(entrada[2]);
            movil[3] = Integer.parseInt(entrada[3]);

            izda = esBalenceado(movil);
            pi = movil[4];

        }

        boolean dcha = true;
        if (pd == 0) {
            entrada = sc.nextLine().split(" ");
            movil[0] = Integer.parseInt(entrada[0]);
            movil[1] = Integer.parseInt(entrada[1]);
            movil[2] = Integer.parseInt(entrada[2]);
            movil[3] = Integer.parseInt(entrada[3]);

            dcha = esBalenceado(movil);
            pd = movil[4];
        }

        if (pi != 0 && pd != 0) {
            movil[4] = pi + pd;
        }

        return izda && dcha && pi * di == pd * dd;
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        int[] movil = new int[5];
        String[] entrada = sc.nextLine().split(" ");
        boolean balancea;
        while (!(entrada[0].equals("0") && entrada[1].equals("0") && entrada[2].equals("0") && entrada[3].equals("0"))) {
            for (int i = 0; i < entrada.length; i++) {
                movil[i] = Integer.parseInt(entrada[i]);
            }

            balancea = esBalenceado(movil);

            if (balancea) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
            movil[4] = 0;
            entrada = sc.nextLine().split(" ");
        }
        sc.close();
        System.exit(0);
    }

}

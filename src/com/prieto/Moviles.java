package com.prieto;

public class Moviles {
    static java.util.Scanner sc;

    static int pesoIzdo = 0;

    static int pesoDcho = 0;

    public static boolean esBalenceado(int[] movil) {
        String[] entrada;
        int pi = movil[0];
        int di = movil[1];
        int pd = movil[2];
        int dd = movil[3];
        boolean izda = true;
        if (pi == 0) {
            entrada = sc.nextLine().split(" ");
            int ipi = Integer.parseInt(entrada[0]);
            int idi = Integer.parseInt(entrada[1]);
            int ipd = Integer.parseInt(entrada[2]);
            int idd = Integer.parseInt(entrada[3]);
            movil[0] = ipi;
            movil[1] = idi;
            movil[2] = ipd;
            movil[3] = idd;

            izda = esBalenceado(movil);
            if (pi == 0 && pd == 0)
                movil[4] = ipi + ipd;
           
        }

        boolean dcha = true;
        if (pd == 0) {
            entrada = sc.nextLine().split(" ");
            int dpi = Integer.parseInt(entrada[0]);
            int ddi = Integer.parseInt(entrada[1]);
            int dpd = Integer.parseInt(entrada[2]);
            int ddd = Integer.parseInt(entrada[3]);
            movil[0] = dpi;
            movil[1] = ddi;
            movil[2] = dpd;
            movil[3] = ddd;

            dcha = esBalenceado(movil);
            if (pi == 0 && pd == 0)
                movil[5] = dpi + dpd;
        }

        if (pi == 0) {
            pi = movil[4];
            movil[0]=pi;
        }
        if (pd == 0) {
            pd = movil[5];
            movil[2]=pd;
        }

        return izda && dcha && pi * di == pd * dd;
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        int[] movil = new int[6];
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

            entrada = sc.nextLine().split(" ");
        }
        sc.close();
        System.exit(0);
    }

}

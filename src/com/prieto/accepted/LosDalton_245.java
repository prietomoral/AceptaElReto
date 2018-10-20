package com.prieto.accepted;

public class LosDalton_245 {
    static java.util.Scanner sc;

    public static void casosdeprueba(long numPersonas) {
        String resultado = "DALTON";
        long altura = sc.nextLong();
        long alturaNueva = sc.nextLong();

        if (alturaNueva > altura) {
            numPersonas--;
            altura = alturaNueva;
            while (numPersonas > 1) {
                alturaNueva = sc.nextLong();
                if (alturaNueva > altura) {
                    numPersonas--;
                    altura = alturaNueva;
                } else {
                    resultado = "DESCONOCIDOS";
                    sc.nextLine();
                    break;
                }

            }
        } else if (alturaNueva < altura) {
            numPersonas--;
            altura = alturaNueva;
            while (numPersonas > 1) {
                alturaNueva = sc.nextLong();
                if (alturaNueva < altura) {
                    numPersonas--;
                    altura = alturaNueva;
                } else {
                    resultado = "DESCONOCIDOS";
                    sc.nextLine();
                    break;
                }
            }
        } else {
            resultado = "DESCONOCIDOS";
            sc.nextLine();
        }

        System.out.println(resultado);
    }

    public static void main(String[] args) {
        sc = new java.util.Scanner(System.in);
        long numPersonas = sc.nextLong();
        while (numPersonas != 0) {
            if (numPersonas > 2) {
                casosdeprueba(numPersonas);
            }
            numPersonas = sc.nextLong();
        }
        sc.close();
        System.exit(0);
    }

}

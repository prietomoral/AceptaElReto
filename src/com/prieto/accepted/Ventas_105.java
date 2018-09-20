package com.prieto.accepted;

import java.util.HashMap;
import java.util.Map;

public class Ventas_105 {
    static java.util.Scanner sc;

    static Map<String, Double> ventas = new HashMap<String, Double>();

    public static String[] diaDeSemana = {"MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};

    public static void inicializarVentas() {
        for (int i = 0; i < diaDeSemana.length; i++) {
            ventas.put(diaDeSemana[i], 0d);
        }
    }

    public static void main(String[] args) {

        boolean empateMinimo = false;
        boolean empateMaximo = false;
        double ventaMinima = 0d;
        String diaMinimo = "";
        double ventaMaxima = 0d;
        String diaMaximo = "";

        double ventaSemanal = 0d;

        sc = new java.util.Scanner(System.in);
        double valor = Double.parseDouble(sc.nextLine());
        int i = 0;

        while (!(valor == -1 && diaDeSemana[i].equals("MARTES"))) {

            if (diaDeSemana[i].equals("MARTES")) {
                if (valor == -1) {
                    break;
                }
                ventaMinima = valor;
                ventaMaxima = valor;
                diaMinimo = diaDeSemana[i].toString();
                diaMaximo = diaDeSemana[i].toString();
            } else if (valor < ventaMinima) {
                ventaMinima = valor;
                diaMinimo = diaDeSemana[i].toString();
                empateMinimo = false;
            } else if (valor > ventaMaxima) {
                ventaMaxima = valor;
                diaMaximo = diaDeSemana[i].toString();
                empateMaximo = false;
            } else if (valor == ventaMinima) {
                empateMinimo = true;
            } else if (valor == ventaMaxima) {
                empateMaximo = true;
            }

            ventaSemanal = ventaSemanal + valor;
            ventas.put(diaDeSemana[i].toString(), valor);

            // procesar semana
            if (diaDeSemana[i].equals("DOMINGO")) {

                if (ventaMinima == ventaMaxima) {
                    empateMinimo = true;
                    empateMaximo = true;
                }

                if (!empateMaximo) {
                    System.out.print(diaMaximo + " ");
                } else {
                    System.out.print("EMPATE ");
                }

                if (!empateMinimo) {
                    System.out.print(diaMinimo + " ");
                } else {
                    System.out.print("EMPATE ");
                }

                // Ventas del Domingo > venta semanal

                double ventaDomingo = ventas.get("DOMINGO");
                double ventaMediaSemanal = ventaSemanal / 6;

                if (ventaDomingo > ventaMediaSemanal) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }

                inicializarVentas();
                i = 0;
                ventaSemanal = 0;
                empateMinimo = false;
                empateMaximo = false;
                ventaMinima = 0d;
                diaMinimo = "";
                ventaMaxima = 0d;
                diaMaximo = "";

            } else {
                i++;
            }
            valor = Double.parseDouble(sc.nextLine());
        }
        sc.close();
        System.exit(0);
    }

}

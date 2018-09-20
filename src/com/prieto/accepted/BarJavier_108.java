package com.prieto.accepted;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BarJavier_108 {
    static java.util.Scanner sc;

    static Map<String, Double> ventas = new HashMap<String, Double>();

    static double valorTotal = 0;

    static int numVentas = 0;

    static double valorTotalComidas = 0;

    static int numVentasComidas = 0;

    static String maxCategoria = "";

    static String minCategoria = "";

    static boolean empateMinimo = false;

    static boolean empateMaximo = false;

    public enum CodigosCategorias {
        D, A, M, I, C
    }

    static String convertirCodigoACategoria(String codigo) {
        String categoria = "";
        switch (codigo) {
        case "D":
            categoria = "DESAYUNOS";
            break;
        case "A":
            categoria = "COMIDAS";
            break;
        case "M":
            categoria = "MERIENDAS";
            break;
        case "I":
            categoria = "CENAS";
            break;
        case "C":
            categoria = "COPAS";
            break;

        default:
            break;
        }

        return categoria;
    }

    public static void casosdeprueba(String categoria, double valor) {
        inicializarVentas();
        contabilizarDia(categoria, valor);
        maximosMinimosEmpates();
        imprimirResultado();
    }

    public static void inicializarVentas() {
        for (CodigosCategorias cat : CodigosCategorias.values()) {
            ventas.put(cat.toString(), 0d);
        }
    }

    public static void contabilizarDia(String categoria, double valor) {
        String[] entrada = null;
        while (!(categoria.equals("N") && valor == 0)) {
            if (ventas.containsKey(categoria)) {
                ventas.put(categoria, (double) (ventas.get(categoria) + valor));
                if (categoria.equals("A")) {
                    valorTotalComidas = valorTotalComidas + valor;
                    numVentasComidas++;
                } else {
                    valorTotal = valorTotal + valor;
                    numVentas++;
                }
            }
            entrada = sc.nextLine().split(" ");
            categoria = entrada[0];
            valor = Double.parseDouble(entrada[1]);
        }
    }

    public static void maximosMinimosEmpates() {

        double maximo = 0.0;
        double minimo = 0.0;

        Iterator<String> it = ventas.keySet().iterator();
        for (int i = 0; i < 5; i++) {
            String key = (String) it.next();
            if (i == 0) {
                maximo = ventas.get(key);
                minimo = ventas.get(key);
                minCategoria = key;
                maxCategoria = key;
            } else {
                if (ventas.get(key) < minimo) {
                    minimo = ventas.get(key);
                    minCategoria = key;
                    empateMinimo = false;
                } else if (ventas.get(key) > maximo) {
                    maximo = ventas.get(key);
                    maxCategoria = key;
                    empateMaximo = false;
                } else if (ventas.get(key) == minimo)
                    empateMinimo = true;
                else if (ventas.get(key) == maximo)
                    empateMaximo = true;
            }
        }

        if (minimo == maximo) {
            empateMinimo = true;
            empateMaximo = true;
        }
    }

    public static void imprimirResultado() {
        if (empateMaximo) {
            System.out.print("EMPATE#");
        } else {
            System.out.print(convertirCodigoACategoria(maxCategoria) + "#");
        }
        if (empateMinimo) {
            System.out.print("EMPATE#");
        } else {
            System.out.print(convertirCodigoACategoria(minCategoria) + "#");
        }

        String mayorMediaComidas = "NO";
        if (mayorMediaComidas()) {
            mayorMediaComidas = "SI";
        }
        System.out.println(mayorMediaComidas);

    }

    public static boolean mayorMediaComidas() {
        double resultadoTotalComidas = 0;
        if (numVentasComidas > 0) {
            resultadoTotalComidas = (valorTotalComidas / numVentasComidas);
        }

        double resultadoTotal = valorTotal / numVentas;

        if (resultadoTotalComidas > resultadoTotal)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);

        String[] entrada = null;
        while (sc.hasNext()) {
            try {
                entrada = sc.nextLine().split(" ");
                String categoria = entrada[0].trim().toUpperCase();
                double valor = Double.parseDouble(entrada[1].trim());
                casosdeprueba(categoria, valor);
                numVentas = 0;
                numVentasComidas = 0;
                valorTotalComidas = 0;
                valorTotal = 0;
                maxCategoria = "";
                minCategoria = "";
                empateMinimo = false;
                empateMaximo = false;

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            }
        }

        sc.close();
        System.exit(0);
    }

}

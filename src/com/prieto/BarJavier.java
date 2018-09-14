package com.prieto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BarJavier {
    static java.util.Scanner sc;

    static Map<String, Float> ventas = new HashMap<String, Float>();

    static float valorTotal = 0;

    static int numVentas = 0;

    static float valorTotalComidas = 0;

    static int numVentasComidas = 0;

    static String maxCategoria = "";

    static String minCategoria = "";

    static boolean empateminimo = false;

    static boolean empatemaximo = false;

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

    public static void casosdeprueba(String categoria, float valor) {
        inicializarVentas();
        contabilizarDia(categoria, valor);
        maximosMinimosEmpates();
        imprimirResultado();
    }

    public static void inicializarVentas() {
        for (CodigosCategorias cat : CodigosCategorias.values()) {
            ventas.put(cat.toString(), 0.0f);
        }
    }

    public static void contabilizarDia(String categoria, float valor) {
        String[] entrada = null;
        while (!(categoria.equals("N") && valor == 0)) {
            if (ventas.containsKey(categoria)) {
                ventas.put(categoria, (float) (ventas.get(categoria) + valor));
                valorTotal = valorTotal + valor;
                numVentas++;
                if (categoria.equals("A")) {
                    valorTotalComidas = valorTotalComidas + valor;
                    numVentasComidas++;
                }
            }
            entrada = sc.nextLine().split(" ");
            categoria = entrada[0];
            valor = Float.parseFloat(entrada[1]);
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
                    empateminimo = false;
                } else if (ventas.get(key) > maximo) {
                    maximo = ventas.get(key);
                    maxCategoria = key;
                    empatemaximo = false;
                } else if (ventas.get(key) == minimo)
                    empateminimo = true;
                else if (ventas.get(key) == maximo)
                    empatemaximo = true;
            }
        }

        if (minimo == maximo) {
            empateminimo = true;
            empatemaximo = true;
        }
    }

    public static void imprimirResultado() {
        if (empatemaximo) {
            System.out.print("EMPATE#");
        } else {
            System.out.print(convertirCodigoACategoria(maxCategoria) + "#");
        }
        if (empateminimo) {
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
        float resultadoTotalComidas = 0;
        if (numVentasComidas > 0) {
            resultadoTotalComidas = valorTotalComidas / numVentasComidas;
        }

        float resultadoTotal = valorTotal / numVentas;

        if (resultadoTotalComidas > resultadoTotal)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);

        String input = sc.nextLine();
        String[] entrada = null;
        while (!input.equals("")) {
            try {
                entrada = input.split(" ");
                String categoria = entrada[0];
                float valor = Float.parseFloat(entrada[1]);
                casosdeprueba(categoria, valor);
                numVentas=0;
                numVentasComidas=0;
                valorTotalComidas=0;
                valorTotal=0;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            }
            input = sc.nextLine();
        }

        sc.close();
        System.exit(0);
    }

}

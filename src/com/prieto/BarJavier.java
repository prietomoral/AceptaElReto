package com.prieto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BarJavier {
    static java.util.Scanner sc;

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

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        Map<String, Float> ventas = new HashMap<String, Float>();
        String input = sc.nextLine();
        String[] entrada = null;
        while (!input.equals("")) {
            entrada = input.split(" ");
            String categoria = entrada[0];
            float valor = Float.parseFloat(entrada[1]);

            float valorTotal = 0;
            int numVentas = 0;
            float valorTotalComidas = 0;
            int numVentasComidas = 0;
            ventas.put("D", (float) 0);
            ventas.put("A", (float) 0);
            ventas.put("M", (float) 0);
            ventas.put("I", (float) 0);
            ventas.put("C", (float) 0);

            while (categoria.equals("D") || categoria.equals("A") || categoria.equals("M") || categoria.equals("I")
                    || categoria.equals("C")) {
                ventas.put(categoria, (float) (ventas.get(categoria) + valor));
                valorTotal = valorTotal + valor;
                numVentas++;
                if (categoria.equals("A")) {
                    valorTotalComidas = valorTotalComidas + valor;
                    numVentasComidas++;
                }

                entrada = sc.nextLine().split(" ");
                categoria = entrada[0];
                valor = Float.parseFloat(entrada[1]);
            }
            // Tenemos el diccionario Ventas relleno, ahora hay que determinar el maximo ,minimo, empate maximo o empate minimo

            if (categoria.equals("N") && valor == 0) {

                double maximo = 0.0;
                double minimo = 0.0;
                String maxCategoria = "";
                String minCategoria = "";
                boolean empateminimo = false;
                boolean empatemaximo = false;
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
                float resultadoTotalComidas = 0;
                if (numVentasComidas > 0)
                    resultadoTotalComidas = valorTotalComidas / numVentasComidas;
                float resultadoTotal = valorTotal / numVentas;
                if (resultadoTotalComidas > resultadoTotal)
                    mayorMediaComidas = "SI";

                System.out.println(mayorMediaComidas);
            }
            input = sc.nextLine();

        }
        sc.close();
        System.exit(0);
    }

}

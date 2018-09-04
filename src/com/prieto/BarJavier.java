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
        Map<String, Double> ventas = new HashMap<String, Double>();
        String input = sc.nextLine();
        String[] entrada = null;
        while (!input.equals("")) {
            entrada = input.split(" ");
            double valorTotal = 0;
            int numVentas = 0;
            double valorTotalComidas = 0;
            int numVentasComidas = 0;
            ventas.put("D", 0.0);
            ventas.put("A", 0.0);
            ventas.put("M", 0.0);
            ventas.put("I", 0.0);
            ventas.put("C", 0.0);
            String categoria = entrada[0];
            double valor = Double.parseDouble(entrada[1]);

            while (!(categoria.equals("N") && valor == 0)) {
                ventas.put(categoria, ventas.get(categoria) + valor);
                valorTotal = valorTotal + valor;
                numVentas++;
                if (categoria.equals("A")) {
                    valorTotalComidas = valorTotalComidas + valor;
                    numVentasComidas++;
                }

                entrada = sc.nextLine().split(" ");
                categoria = entrada[0];
                valor = Double.parseDouble(entrada[1]);
            }
            // Tenemos el diccionario Ventas relleno, ahora hay que determinar el maximo ,minimo, empate maximo o empate minimo

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
            double resultadoTotalComidas = 0;
            if (numVentasComidas > 0)
                resultadoTotalComidas = valorTotalComidas / numVentasComidas;
            double resultadoTotal = valorTotal / numVentas;
            if (resultadoTotalComidas > resultadoTotal)
                mayorMediaComidas = "SI";
            
            System.out.println(mayorMediaComidas);
            

            input = sc.nextLine();

        }
        sc.close();
        System.exit(0);
    }

}

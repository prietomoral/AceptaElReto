package com.prieto;

import java.util.ArrayList;
import java.util.Collections;
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
      
        while (input.length() > 0) {
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

            ArrayList<Double> valores = new ArrayList<Double>(ventas.values());
            Collections.sort(valores);

            String minCat = "";
            String maxCat = "";
            if (valores.get(0).equals(valores.get(1))) {
                minCat = "EMPATE";
            }
            if (valores.get(3).equals(valores.get(4))) {
                maxCat = "EMPATE";
            }

            double max = (double) Collections.max(valores);
            double min = (double) Collections.min(valores);

            Iterator<String> it = ventas.keySet().iterator();
            while (it.hasNext() && (minCat.equals("") || maxCat.equals(""))) {
                String key = (String) it.next();
                if (minCat.equals("") && ventas.get(key) == min) {
                    minCat = key;
                }
                if (maxCat.equals("") && ventas.get(key) == max) {
                    maxCat = key;
                }
            }

            String mayorMediaComidas = "NO";
            double resultadoTotalComidas = 0;
            if (numVentasComidas > 0)
                resultadoTotalComidas = valorTotalComidas / numVentasComidas;
            double resultadoTotal = valorTotal / numVentas;
            if (resultadoTotalComidas > resultadoTotal)
                mayorMediaComidas = "SI";
            if (!maxCat.equals("EMPATE"))
                maxCat = convertirCodigoACategoria(maxCat);
            if (!minCat.equals("EMPATE"))
                minCat = convertirCodigoACategoria(minCat);

            System.out.println(maxCat + "#" + minCat + "#" + mayorMediaComidas);
            input = sc.nextLine();
            
        }
        sc.close();
        System.exit(0);
    }

}

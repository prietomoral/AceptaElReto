package com.prieto.accepted;

import java.util.HashMap;
import java.util.Map;

public class CodigoDeBarras_106 {
    static java.util.Scanner sc;

    private static final String EAN8 = "%08d";

    private static final String EAN13 = "%013d";

    static Map<String, String> paises = new HashMap<String, String>();

    public static void inicializarPaises() {
        paises.put("0", "EEUU");
        paises.put("380", "Bulgaria");
        paises.put("50", "Inglaterra");
        paises.put("539", "Irlanda");
        paises.put("560", "Portugal");
        paises.put("70", "Noruega");
        paises.put("759", "Venezuela");
        paises.put("850", "Cuba");
        paises.put("890", "India");
    }

    static String completarCeros(long codigo, String formato) {
        return String.format(formato, codigo);
    }

    static boolean validarDG(String codigo, String formato) {
        long res = 0;
        int mult = 3;

        if (formato.equals(EAN13)) {
            mult = 1;
        }

        for (int i = 0; i < codigo.length() - 1; i++) {

            res = res + (Integer.valueOf(Character.getNumericValue(codigo.charAt(i))) * mult);
            if (mult == 3) {
                mult = 1;
            } else {
                mult = 3;
            }
        }
        
        int ultDigit =  Character.getNumericValue(codigo.charAt(codigo.length()-1));
        return ((res + ultDigit) % 10) == 0;
    }

    static String obtenerPais(String codigo) {
        String pais = "Desconocido";
        inicializarPaises();
        if (paises.containsKey(codigo.substring(0, 3))) {
            pais = paises.get(codigo.substring(0, 3));
        } else if (paises.containsKey(codigo.substring(0, 2))) {
            pais = paises.get(codigo.substring(0, 2));
        } else if (paises.containsKey(codigo.substring(0, 1))) {
            pais = paises.get(codigo.substring(0, 1));
        }
        return pais;
    }

    public static void casosdeprueba(String codigo) {
        int lenCodigo = codigo.length();
        boolean dgOK;
        String formato = null;
        if (lenCodigo < 9) {
            formato = EAN8;
        } else if (lenCodigo > 8 && lenCodigo < 14) {
            formato = EAN13;
        }
        if (formato != null) {
            String codigoFormateado = completarCeros(Long.parseLong(codigo), formato);
            dgOK = validarDG(codigoFormateado, formato);
            if (dgOK) {

                if (formato.equals(EAN13)) {
                    System.out.println("SI " + obtenerPais(codigoFormateado));
                } else {
                    System.out.println("SI");
                }
            } else {
                System.out.println("NO");
            }
        }

    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        String numero = sc.nextLine();
        while (Long.parseLong(numero) != 0) {
            casosdeprueba(numero);
            numero = sc.nextLine();
        }
        sc.close();
        System.exit(0);
    }

}

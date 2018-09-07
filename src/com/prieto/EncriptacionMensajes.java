package com.prieto;

public class EncriptacionMensajes {
    static java.util.Scanner sc;

    static String abecedario = "abcdefghijklmnopqrstuvwxyz";

    public static int obtenerDesplazamiento(char caracter) {
        int pos = 15;
        int cont = 0;
        char primeraLetra = 'p';
        while (!abecedario.substring(pos, 1).equals(primeraLetra)) {
            if (pos == abecedario.length()) {
                pos = 0;
            }
            cont++;
        }
        return cont;
    }

    public static String traducir(String linea, int desplazamiento) {

        return linea;
    }

    public static int contarVocales(String linea) {
        int contador = 0;
        for (int x = 0; x < abecedario.length(); x++) {
            if ((abecedario.charAt(x) == 'a') || (abecedario.charAt(x) == 'e') || (abecedario.charAt(x) == 'i')
                    || (abecedario.charAt(x) == 'o') || (abecedario.charAt(x) == 'u')) {
                contador++;
            }
        }
        return contador;
    }

    public static String casosdeprueba() {
        String linea = sc.nextLine().toLowerCase();
        int desplazamiento = obtenerDesplazamiento(linea.charAt(0));
        linea = traducir(linea, desplazamiento);
        System.out.println(contarVocales(linea.toLowerCase()));
        return linea;
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        String mensaje = "";
        while (!mensaje.toLowerCase().equals("fin")) {
            mensaje = casosdeprueba();
        }
        sc.close();
        System.exit(0);
    }

}

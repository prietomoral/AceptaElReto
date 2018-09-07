package com.prieto;

public class EncriptacionMensajes {
    static java.util.Scanner sc;

    static final String ABECEDARIO = "abcdefghijklmnopqrstuvwxyz";

    static final int POS_LETRA_P = 15;

    static final String FIN = "FIN";

    public static int obtenerDesplazamiento(char caracter) {
        int pos = 0;

        while (ABECEDARIO.charAt(pos) != caracter) {
            pos++;
        }
        return POS_LETRA_P - pos;
    }

    public static int obtenerPosicionLetra(char letra) {
        int pos = 0;
        letra = Character.toLowerCase(letra);
        while (ABECEDARIO.charAt(pos) != letra) {
            pos++;
        }
        return pos;
    }

    public static String traducir(String linea, int desplazamiento) {
        String lineaTraducida = "";
        int pos = 0;
        char caracter;
        for (int i = 1; i < linea.length(); i++) {
            if (Character.isLetter(linea.charAt(i))) {
                pos = obtenerPosicionLetra(linea.charAt(i)) + desplazamiento;
                if (pos >= ABECEDARIO.length()) {
                    pos = pos - ABECEDARIO.length();
                }
                caracter = linea.charAt(i);
                if (Character.isUpperCase(caracter))
                    caracter = Character.toUpperCase(ABECEDARIO.charAt(pos));
                else
                    caracter = ABECEDARIO.charAt(pos);
                lineaTraducida = lineaTraducida + caracter;
            }
        }
        return lineaTraducida;
    }

    public static int contarVocales(String linea) {
        int contador = 0;
        linea = linea.toLowerCase();
        for (int x = 0; x < linea.length(); x++) {
            if ((linea.charAt(x) == 'a') || (linea.charAt(x) == 'e') || (linea.charAt(x) == 'i') || (linea.charAt(x) == 'o')
                    || (linea.charAt(x) == 'u')) {
                contador++;
            }
        }
        return contador;
    }

    public static String casosdeprueba() {
        String linea = sc.nextLine();
        int desplazamiento = obtenerDesplazamiento(linea.charAt(0));
        linea = traducir(linea, desplazamiento);
        if (!linea.equals(FIN)) {
            System.out.println(contarVocales(linea.toLowerCase()));
        }
        return linea;
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        String mensaje = "";
        while (!mensaje.equals(FIN)) {
            mensaje = casosdeprueba();
        }
        sc.close();
        System.exit(0);
    }

}

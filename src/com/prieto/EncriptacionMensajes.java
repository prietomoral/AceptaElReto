package com.prieto;

public class EncriptacionMensajes {
    static java.util.Scanner sc;

    private static final String ABECEDARIO = "abcdefghijklmnopqrstuvwxyz";

    private static final byte P_MAYUS = (byte) 'P';

    private static final byte P_MINUS = (byte) 'p';

    private static final String FIN = "FIN";

    public static int obtenerDesplazamiento(char letra) {

        if (Character.isUpperCase(letra)) {
            return (short) (P_MAYUS - letra);
        } else {
            return (short) (P_MINUS - letra);
        }
    }

    public static int obtenerPosicionLetra(char letra) {
        int posicion = ABECEDARIO.indexOf(letra);
        return posicion;
    }

    public static String traducir(String linea, int desplazamiento) {
        String lineaTraducida = "";
        int pos = 0;
        char caracter;

        for (int i = 1; i < linea.length(); i++) {
            pos = (obtenerPosicionLetra(Character.toLowerCase(linea.charAt(i))) + desplazamiento) % ABECEDARIO.length();
            caracter = linea.charAt(i);
            if (pos >= 0) {
                if (Character.isUpperCase(caracter))
                    caracter = Character.toUpperCase(ABECEDARIO.charAt(pos));
                else
                    caracter = ABECEDARIO.charAt(pos);
            }
            lineaTraducida = lineaTraducida + caracter;

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
        int desplazamiento = 0;

        if (Character.isLetter(linea.charAt(0))) {
            desplazamiento = obtenerDesplazamiento(linea.charAt(0));
            linea = traducir(linea, desplazamiento);
            if (!linea.equals(FIN)) {
                System.out.println(contarVocales(linea.toLowerCase()));
            }
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
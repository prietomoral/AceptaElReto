package com.prieto;

public class EncriptacionMensajes {
    static java.util.Scanner sc;

    static final String ABECEDARIO = "abcdefghijklmnopqrstuvwxyz";

    static final int POS_LETRA_P = 15;

    static final String FIN = "FIN";

    public static int obtenerDesplazamiento(char caracter) {
        int pos = 0;

        pos = obtenerPosicionLetra(caracter);
        return POS_LETRA_P - pos;
    }

//    public static int obtenerPosicionLetra(char letra) {
//        int pos = 0;
//        letra = Character.toLowerCase(letra);
//        boolean enc = false;
//        while (!enc && pos < ABECEDARIO.length()) {
//            if (ABECEDARIO.charAt(pos) == letra) {
//                enc = true;
//            }
//            pos++;
//        }
//        if (!enc)
//            pos = -1;
//
//        return pos;
//    }

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

        if (Character.isLetter(linea.charAt(0)) && obtenerPosicionLetra(linea.charAt(0)) >= 0) {
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

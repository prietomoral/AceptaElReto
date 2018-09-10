package com.prieto;

public class FiestaVerano {
    static java.util.Scanner sc;

    public static long obtenerTotalPersonas(String[] tramosEdad) {
        long totalPersonas = 0;
        long MAXIMO_PERSONAS = 1000000000000000000L;
        try {

            // valido que el ultimo valor sea 0
            if (Long.parseLong(tramosEdad[tramosEdad.length - 1]) == 0) {
                for (int i = 0; i < tramosEdad.length - 1; i++) {
                    // valido que haya mas de una persona por tramo
                    if (Long.parseLong(tramosEdad[i]) < 1) {
                        totalPersonas = -1;
                        break;
                    }

                    totalPersonas = totalPersonas + Long.parseLong(tramosEdad[i]);
                }
            } else {
                totalPersonas = -1;
            }

            if (totalPersonas > MAXIMO_PERSONAS) {
                totalPersonas = -1;
            }

            return totalPersonas;

        } catch (NumberFormatException e) {
            return totalPersonas = -1;
        }
    }

    public static void casosdeprueba(String entrada) {
        String[] tramosEdad = entrada.split(" ");
        long tramoEdadMinimo = 0;
        long numTramosEdad = tramosEdad.length - 1;

        long totalPersonas = obtenerTotalPersonas(tramosEdad);

        if (totalPersonas > 0 && numTramosEdad > 0) {
            // ObtenemosTramoMenor
            tramoEdadMinimo = Long.parseLong(tramosEdad[0]);
            for (int i = 0; i < tramosEdad.length - 1; i++) {
                if (Long.parseLong(tramosEdad[i]) < tramoEdadMinimo)
                    tramoEdadMinimo = Long.parseLong(tramosEdad[i]);
            }

            // ObtenerNumeroMesasMayores
            boolean enc = false;
            for (long i = tramoEdadMinimo; i >= 1 && !enc; i--) {
                for (int j = 0; j < tramosEdad.length - 1; j++) {
                    if (Long.parseLong(tramosEdad[j]) % i != 0) {
                        break;
                    } else if (j == tramosEdad.length - 2) {
                        System.out.println(totalPersonas / i);
                        enc = true;
                    }

                }
            }
        }

    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        String entrada = sc.nextLine();

        while (!entrada.equals("0")) {
            casosdeprueba(entrada);
            entrada = sc.nextLine();
        }
        sc.close();
        System.exit(0);
    }

}

package com.prieto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class LigaDePadel_109 {
    static java.util.Scanner sc;

    static HashMap<String, Integer> equipos;

    public static void casosdeprueba() {
        String[] partido = sc.nextLine().split(" ");
        equipos = new HashMap<String, Integer>();
        int numPartidos = 0;
        while (!partido[0].equals("FIN")) {
            if (equipos.containsKey(partido[0])) {
                equipos.put(partido[0], equipos.get(partido[0]) + 1);
            } else {
                equipos.put(partido[0], 1);
            }
            if (equipos.containsKey(partido[2])) {
                equipos.put(partido[2], equipos.get(partido[0]) + 1);
            } else {
                equipos.put(partido[2], 1);
            }
            if (Integer.parseInt((partido[1])) > Integer.parseInt((partido[3]))) {
                equipos.put(partido[0], equipos.get(partido[0]) + 1);
            } else {
                equipos.put(partido[2], equipos.get(partido[0]) + 1);
            }
            partido = sc.nextLine().split(" ");
            numPartidos++;
        }
        int maxValueInMap = (Collections.max(equipos.values()));
        String ganador = "";
        Iterator<String> iterator = equipos.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if (equipos.get(key) == maxValueInMap) {
                if (ganador.equals("")) {
                    ganador = key.toString();
                } else {
                    ganador = "EMPATE";
                }
            }
        }
        int noDisputados = (equipos.size() * (equipos.size() - 1)) - numPartidos;

        System.out.println(ganador + " " + String.valueOf(noDisputados));
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        String categoria = sc.nextLine();
        while (!categoria.equals("FIN")) {
            casosdeprueba();
            categoria = sc.nextLine();
        }
        sc.close();
        System.exit(0);
    }

}

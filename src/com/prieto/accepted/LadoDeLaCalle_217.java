package com.prieto.accepted;

public class LadoDeLaCalle_217 {
    static java.util.Scanner sc;

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        short num = sc.nextShort();
        while (num != 0) {
            short res = (short) (num % 2);
            if (res == 0) {
                System.out.println("DERECHA");
            } else {
                System.out.println("IZQUIERDA");
            }
            num = sc.nextShort();
        }
        sc.close();
        System.exit(0);
    }

}

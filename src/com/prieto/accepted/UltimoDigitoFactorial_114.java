package com.prieto.accepted;

import java.math.BigInteger;

public class UltimoDigitoFactorial_114 {
    static java.util.Scanner sc;

//	public static BigInteger factorial(int n) {
//
//		if (n <= 1) {
//			return BigInteger.ONE;
//		} else {
//			BigInteger fac = new BigInteger(String.valueOf(n));
//			return (fac.multiply(factorial(n - 1)));
//		}
//	}

//	public static BigInteger factorialIter(int n) {
//		BigInteger fact = BigInteger.ONE;
//		BigInteger i;
//		if (n == 0) {
//			fact = BigInteger.ONE;
//		} else {
//			for (i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(n+1)) < 0 ; i = i.add(BigInteger.ONE)  ) {
//				fact = fact.multiply(i);
//			}
//		}
//
//		return fact;
//	}
//
//	public static void casosdeprueba() {
//		//BigInteger res = factorial(sc.nextInt());
//		BigInteger res = factorialIter(sc.nextInt());
//		
//		String resString = String.valueOf(res);
//		char lastDigit = resString.charAt(resString.length() - 1);
//
//		System.out.println(lastDigit);
//	}

    public static void casosdeprueba2() {

        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(1);
        } else if (n == 3) {
            System.out.println(6);
        }else if (n<5) {
            System.out.println(n);
        }else {
            System.out.println(0);
        }

        
    }

    public static void main(String[] args) {

        sc = new java.util.Scanner(System.in);
        int numcasos = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numcasos; i++) {
            casosdeprueba2();
        }
        sc.close();
        System.exit(0);
    }

}

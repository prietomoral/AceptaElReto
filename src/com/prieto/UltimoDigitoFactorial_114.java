package com.prieto;

public class UltimoDigitoFactorial_114 {
	static java.util.Scanner sc;
	
	public static int factorial(int numero) {
		if (numero == 0) {
			return 1 ;
		}else {
			return numero * factorial(numero -1);
		}
	}
	
	public static void casosdeprueba() {
		int num = sc.nextInt();
		
		int res = factorial(num);
		
		String.valueOf(res).substring(beginIndex, endIndex)
		
	}
	
	
	
	public static void main(String[] args) {
		
		sc = new java.util.Scanner(System.in);
		int numcasos = sc.nextInt();
		for (int i = 0; i < numcasos; i++) {
			casosdeprueba();
		}
		sc.close();
		System.exit(0);
	}

}

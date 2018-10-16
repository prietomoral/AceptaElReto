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
		int num = Integer.parseInt(sc.nextLine());
		int res = factorial(num);
		
		char lastDigit = String.valueOf(res).charAt(String.valueOf(res).length()-1);
		System.out.println(lastDigit);
		
	}
	
	
	
	public static void main(String[] args) {
		
		sc = new java.util.Scanner(System.in);
		int numcasos =  Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numcasos; i++) {
			casosdeprueba();
		}
		sc.close();
		System.exit(0);
	}

}

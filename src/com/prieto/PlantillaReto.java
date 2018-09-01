package com.prieto;

public class PlantillaReto {
	static java.util.Scanner sc;
	
	
	public static void casosdeprueba() {
		int n = sc.nextInt();
	   
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

package com.prieto;

public class PlantillaReto {
	static java.util.Scanner in;
	
	
	public static void casosdeprueba() {
		int n = in.nextInt();
	   
	}
	
	
	
	public static void main(String[] args) {
		
		in = new java.util.Scanner(System.in);
		int numcasos = in.nextInt();
		for (int i = 0; i < numcasos; i++) {
			casosdeprueba();
		}
		in.close();
		System.exit(0);
	}

}

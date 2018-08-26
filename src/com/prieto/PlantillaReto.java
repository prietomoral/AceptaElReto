package com.prieto;

public class PlantillaReto {
	static java.util.Scanner in;
	
	
	public static void casosdeprueba() {
		Integer n = in.nextInt();
	    System.out.println(n);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new java.util.Scanner(System.in);
		int numcasos = in.nextInt();
		for (int i = 0; i < numcasos; i++) {
			casosdeprueba();
		}
		in.close();
		System.exit(0);
	}

}

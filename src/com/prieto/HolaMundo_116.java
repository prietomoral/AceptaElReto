package com.prieto;

public class HolaMundo_116 {
	static java.util.Scanner sc;

	public static void main(String[] args) {

		sc = new java.util.Scanner(System.in);
		int n = sc.nextInt();
		if (n >= 0 && n <= 5) {
			for (int i = 0; i < n; i++) {
				System.out.println("Hola mundo.");
			}
		}
		sc.close();
		System.exit(0);
	}

}

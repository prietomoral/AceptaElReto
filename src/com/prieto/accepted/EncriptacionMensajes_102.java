package com.prieto.accepted;

public class EncriptacionMensajes_102 {
	static java.util.Scanner sc;

	public static int desp;

	public static char suma(char a) {
		if ((a + desp) > 90)
			return (char) (a + desp - 90 + 64);
		else if ((a + desp) < 65)
			return (char) (a + desp - 65 + 91);
		return (char) (a + desp);
	}

	public static void main(String[] args) {

		sc = new java.util.Scanner(System.in);
		String linea = sc.nextLine();
		while (!linea.equals("")) {
			char codigoP = Character.toUpperCase((linea.charAt(0)));
			desp = 'P' - codigoP;
			if (linea.length() == 4 && suma(linea.charAt(1)) == 'F' && suma(linea.charAt(2)) == 'I'
					&& suma(linea.charAt(3)) == 'N') {
				break;
			}

			linea = linea.toUpperCase();
			int numVocales = 0;
			for (int i = 1; i < linea.length(); i++) {
				if (!(linea.charAt(i) >= 'A' && linea.charAt(i) <= 'Z')) {
					continue;
				} else if (suma(linea.charAt(i)) == 'A' || suma(linea.charAt(i)) == 'E' || suma(linea.charAt(i)) == 'O'
						|| suma(linea.charAt(i)) == 'I' || suma(linea.charAt(i)) == 'U') {
					numVocales++;
				}
			}

			System.out.println(numVocales);
			linea = sc.nextLine();
		}
		sc.close();
		System.exit(0);
	}

}

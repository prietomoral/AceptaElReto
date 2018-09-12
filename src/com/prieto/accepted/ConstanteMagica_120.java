package com.prieto.accepted;

public class ConstanteMagica_120 {
	static java.util.Scanner sc;

	public static void main(String[] args) {
		sc = new java.util.Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int n = Integer.parseInt(entrada[0]);
		int k = Integer.parseInt(entrada[1]);
		while (!(n == 0 && k == 0)) {
			int columnaCentral = (n / 2) + 1;
			int inicioDiagonal = k + (n * (n - columnaCentral));
			int constanteMagica = 0;
			for (int i = 0; i < n; i++) {
				constanteMagica = constanteMagica + (inicioDiagonal + i);
			}

			System.out.println(constanteMagica);

			entrada = sc.nextLine().split(" ");
			n = Integer.parseInt(entrada[0]);
			k = Integer.parseInt(entrada[1]);
		}

		sc.close();
		System.exit(0);
	}

}

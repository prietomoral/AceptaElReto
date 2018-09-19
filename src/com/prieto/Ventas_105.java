package com.prieto;

import java.util.HashMap;
import java.util.Map;

public class Ventas_105 {
	static java.util.Scanner sc;
	static Map<String, Double> ventas = new HashMap<String, Double>();

	public enum DIA_DE_SEMANA {
		MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
	}

	public static void inicializarVentas() {
		for (DIA_DE_SEMANA dia : DIA_DE_SEMANA.values()) {
			ventas.put(dia.toString(), 0d);
		}
	}

	public static void main(String[] args) {

		boolean empateMinimo = false;
		boolean empateMaximo = false;
		double ventaMinima = 0d;
		String diaMinimo = "";
		double ventaMaxima = 0d;
		String diaMaximo = "";

		double ventaSemanal = 0d;

		sc = new java.util.Scanner(System.in);
		double valor = Double.parseDouble(sc.nextLine());

		while (valor != -1) {
			inicializarVentas();
			// leer semana de ventas
			for (DIA_DE_SEMANA dia : DIA_DE_SEMANA.values()) {
				ventas.put(dia.toString(), valor);

				if (dia.toString().equals("MARTES")) {
					ventaMinima = valor;
					ventaMaxima = valor;
					diaMinimo = dia.toString();
					diaMaximo = dia.toString();
				} else if (valor < ventaMinima) {
					ventaMinima = valor;
					diaMinimo = dia.toString();
					empateMinimo = false;
				} else if (valor > ventaMaxima) {
					ventaMaxima = valor;
					diaMaximo = dia.toString();
					empateMaximo = false;
				} else if (valor == ventaMinima) {
					empateMinimo = true;
				} else if (valor == ventaMaxima) {
					empateMaximo = true;
				}

				ventaSemanal = ventaSemanal + valor;

				valor = Double.parseDouble(sc.nextLine());
			}

			if (ventaMinima == ventaMaxima) {
				empateMinimo = true;
				empateMaximo = true;
			}

			// procesar semana

			if (!empateMaximo) {
				System.out.print(diaMaximo + " ");
			} else {
				System.out.print("EMPATE ");
			}

			if (!empateMinimo) {
				System.out.print(diaMinimo + " ");
			} else {
				System.out.print("EMPATE ");
			}

			// Ventas del Domingo > venta semanal

			double ventaDomingo = ventas.get("DOMINGO");
			double ventaMediaSemanal = ventaSemanal / 6;

			if (ventaDomingo > ventaMediaSemanal) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}

		}
		sc.close();
		System.exit(0);
	}

}

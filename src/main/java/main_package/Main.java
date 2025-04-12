package main_package;


import java.util.Scanner;

import java.io.IOException;

import main_package.models.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite a moeda principal (USD, BRL, EUR): ");
		String moeda1 = scan.nextLine();
		System.out.println("Digite a moeda para comparar (USD, BRL, EUR): ");
		String moeda2 = scan.nextLine();
		System.out.println("Digite o valor a ser comparado: ");
		double value = scan.nextDouble();
		
		Exchange moeda = new Exchange(moeda1.toUpperCase(), moeda2.toUpperCase(), value);
		
		System.out.println(moeda.toString());	
		
		System.exit(0);
	}
}

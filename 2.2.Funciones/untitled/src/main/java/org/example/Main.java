package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese un número");
        int numero = scanner.nextInt();
        if (numeroPrimo(numero)){
            System.out.println(numero+" es un número primo");
        } else{
        System.out.println(numero+" no es un número primo");}
    }

    public static boolean numeroPrimo(int numero) {
        if (numero == 2 || numero == 3 || numero == 5 || numero == 7) {
            return true;
        }
        for (int i = 2; i <= 9; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
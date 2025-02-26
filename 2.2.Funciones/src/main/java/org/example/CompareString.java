package org.example;

import java.util.Scanner;

public class CompareString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese un texto1");
        String texto1 = scanner.nextLine();
        System.out.println("ingrese un texto2");
        String texto2 = scanner.nextLine();
        if (comparacion(texto1, texto2)) {
            System.out.println(texto1 + " es igual a " + texto2);
        } else {
            System.out.println(texto1 + " es diferente a " + texto2);
        }
    }
    public static  boolean comparacion(String texto1, String texto2){
        if(texto1.equals(texto2)) {
           return true;
        }
        return false;
    }
}

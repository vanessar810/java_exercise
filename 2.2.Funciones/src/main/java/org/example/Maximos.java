package org.example;

import java.util.Scanner;

public class Maximos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese tres números separados por espacios");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int respuesta = numeroMaximo(num1,num2,num3);
        System.out.println("el número mayor es: "+respuesta);

    }

    public static int numeroMaximo(int num1, int num2, int num3){
        if(num1>=num2 && num1>=num3){
            return num1;
        }if(num2>=num1 && num2>=num3){
            return num2;
        }if(num3>=num1 && num3>=num2){
            return num3;
        } return 10;
    }
}

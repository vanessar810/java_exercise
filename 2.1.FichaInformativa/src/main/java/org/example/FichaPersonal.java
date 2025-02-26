package org.example;

import java.util.Scanner;

public class FichaPersonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese su nombre");
        String nombre = scanner.nextLine();
        System.out.println("ingrese su apellido");
        String apellido = scanner.nextLine();
        System.out.println("ingrese fecha de nacimiento, separado por espacios");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int anio = scanner.nextInt();

        String iniciales = obtenerIniciales(nombre, apellido);
        String fechaNacimiento = obtenerFechaNacimiento(dia, mes, anio);

        String Ficha = "Nombre completo: "+nombre+" "+apellido+"\n"+"Iniciales: "+iniciales+"\n"
        +"Fecha de nacimiento:"+fechaNacimiento;
        System.out.println(Ficha);

    }

    public static String obtenerIniciales(String nombre, String apellido){
        char inicialNombre = nombre.charAt(0);
        char inicialApellido = apellido.charAt(0);
        return inicialNombre+ " " +inicialApellido;
    }

    public static String obtenerFechaNacimiento(int dia, int mes, int anio){
        String diaStr = String.format("%02d",dia);
        String mesStr = String.format("%02d", mes);
        return diaStr+"/"+mesStr+"/"+anio;
    }
}

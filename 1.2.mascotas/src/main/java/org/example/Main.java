package org.example;

public class Main {
    public static void main(String[] args) {
       Mascota mascota1 = new Mascota("Manchitas", 2, 1.5,"guau guau");
       Mascota mascota2 = new Mascota("Nemo", 1, 0.14,"splash splash");
       Mascota mascota3 = new Mascota("silvestre", 3,0.5, "miau, miau");
       Mascota mascota4 = new Mascota("Manuelita", 12, 0.300, "vivia en la selva");
       Mascota mascota5 = new Mascota("Gardel", 1, 0.350, "piru piru");
       System.out.println(mascota1.getName() + " tiene " + mascota1.getEdad() + " años, come " + mascota1.getAlimento() + " kg y hace: " + mascota1.getSonido());
        System.out.println(mascota2.getName() + " tiene " + mascota2.getEdad() + " años, come " + mascota2.getAlimento() + " kg y hace: " + mascota2.getSonido());
        System.out.println(mascota3.getName() + " tiene " + mascota3.getEdad() + " años, come " + mascota3.getAlimento() + " kg y hace: " + mascota3.getSonido());
        System.out.println(mascota4.getName() + " tiene " + mascota4.getEdad() + " años, come " + mascota4.getAlimento() + " kg y hace: " + mascota4.getSonido());
        System.out.println(mascota5.getName() + " tiene " + mascota5.getEdad() + " años, come " + mascota5.getAlimento() + " kg y hace: " + mascota5.getSonido());
    }
}
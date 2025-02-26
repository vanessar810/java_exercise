package org.example;

public class Mascota {
    private String name;
    private int edad;
    private double alimento;
    private String sonido;

    public Mascota(String name, int edad, double alimento, String sonido) {
        this.name = name;
        this.edad = edad;
        this.alimento = alimento;
        this.sonido = sonido;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAlimento() {
        return alimento;
    }

    public void setAlimento(double alimento) {
        this.alimento = alimento;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
}

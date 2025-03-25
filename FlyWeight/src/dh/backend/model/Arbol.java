package dh.backend.model;

public class Arbol {
    private String tipo;
    private int alto;
    private int ancho;
    private String color;
    private static int contador;

    public Arbol(String tipo, int alto, int ancho, String color) {
        this.tipo = tipo;
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        contador++;
    }

    public static int getContador() {
        return contador;
    }

    @Override
    public String toString() {
        return "Arbol" +
                "tipo='" + tipo + '\'' +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", color='" + color ;
    }
}

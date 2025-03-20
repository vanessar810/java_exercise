package model;

public class Usuario {
    private int identificacion;

    public Tipo tipo;

    public Usuario(int identificacion, Tipo tipo) {
        this.identificacion = identificacion;
        this.tipo = tipo;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}

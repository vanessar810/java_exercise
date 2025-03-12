public class Caja extends Product{
    private double longitud;
    private double ancho;
    private double altura;

    public Caja(double longitud, double ancho, double altura) {
        this.longitud = longitud;
        this.ancho = ancho;
        this.altura = altura;
    }

    @Override
    public double calcularEspacio() {
        double v = longitud*ancho*altura;
        return v;
    }
}

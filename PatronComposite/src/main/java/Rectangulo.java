public class Rectangulo extends Figura{
    private double ancho;
    private double largo;


    public Rectangulo(String name, double ancho, double largo) {
        super(name);
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public double CalcularArea() {
        double area = largo*ancho;
        return area;
    }
}

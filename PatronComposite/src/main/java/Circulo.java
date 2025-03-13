public class Circulo extends Figura{
    private double radio;
    public Circulo(String name, double radio) {
        super(name);
        this.radio = radio;
    }
    @Override
    public double CalcularArea() {
        double area = 3.14*radio*radio;
        return area;
    }
}

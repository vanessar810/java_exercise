public class Triangulo extends Figura{
    private double base;
    private double altura;


    public Triangulo(String name, double base, double altura) {
        super(name);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double CalcularArea() {
        double area = base*altura/2;
        return area;
    }
}

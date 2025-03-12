public class Pelota extends Product{
    private double radio;

    public Pelota(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularEspacio() {
        double v = 4*(Math.PI/3)*Math.pow(radio,3);
        return v;
    }
}

public abstract class Figura {
    private String name;

    public Figura(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract double CalcularArea();
}

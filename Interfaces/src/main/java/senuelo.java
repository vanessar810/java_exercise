public class senuelo extends SistemaArmas{

    private String name;

    public senuelo(Integer energia, String name) {
        super(energia);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public void mostrar() {
        super.mostrar();
    }
}

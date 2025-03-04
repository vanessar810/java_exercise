public class Tanque extends SistemaArmas implements Ataques{
    private String name;

    public Tanque(Integer energia, String name) {
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
    public String ataque(){
        return "Se ha perpetrado el ataque del "+name;
    }

    public String defensa(){
        return "el "+name+" está defendiendo territorio";
    }
}

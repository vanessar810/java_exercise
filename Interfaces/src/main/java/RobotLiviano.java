public class RobotLiviano extends SistemaArmas implements Ataques, Vuelo{
    private String name;

    public RobotLiviano(Integer energia, String name) {
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

    public void volar(){
        System.out.println("el "+ name+" está volando en el área");
    }
}

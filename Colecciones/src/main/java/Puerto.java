import java.util.ArrayList;
import java.util.List;

public class Puerto {
    private String nombre;
    private List<Contenedor> contenedors = new ArrayList<>();

    public Puerto(String nombre) {
        this.nombre = nombre;
    }

    public void agregarContenedor(Contenedor contenedor) {
        contenedors.add(contenedor);
    }

    public void mostrarContenedores() {
        System.out.println("Lista de contenedores: ");
        contenedors.stream().sorted().forEach(contenedor -> System.out.println(contenedor.getIdentificacion() + " from: " + contenedor.getPaisProcedencia()));
    }

}

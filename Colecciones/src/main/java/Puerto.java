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
    public void contenedorPeligrosoDesconocido(){
        System.out.println("Lista de contenedores peligrosos: ");
      contenedors.stream().filter(Contenedor::isMaterialesPeligrosos).filter(Contenedor-> Contenedor.getPaisProcedencia()=="Desconocido")
              .forEach(contenedor -> System.out.println(contenedor.getIdentificacion()));
    }
    public int cantidadPeligrosoDesconocido(){
        return (int)  contenedors.stream().filter(Contenedor::isMaterialesPeligrosos).filter(Contenedor-> Contenedor.getPaisProcedencia()=="Desconocido")
                .count();
    }
}

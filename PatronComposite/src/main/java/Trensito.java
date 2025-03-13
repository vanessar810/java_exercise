import java.util.ArrayList;
import java.util.List;

public class Trensito {
private List<Figura> figuras = new ArrayList<>();
public void agregarFiguras(Figura figura){figuras.add(figura);}

    public void ListarFiguras(){
        System.out.println("El trensito está compuesto por: ");
        for (Figura figura : figuras){
            System.out.println("*");
            System.out.println(figura.getName());
        }
    }
    public double AreaTotal(){
    double area = 0;
    for (Figura figura : figuras){
        area+= figura.CalcularArea();
    }
    return area;
    }
}

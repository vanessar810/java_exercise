import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    private double peso;

    private static final List<Product> productosCreados = new ArrayList<>();
    public Product(){
        productosCreados.add(this);
    }
public abstract double calcularEspacio();
public static double calcularEspacioTotal(){
    return productosCreados.stream().mapToDouble(Product::calcularEspacio).sum();
}
 public static List<Product> getProductosCreados(){
    return productosCreados;
 }
}

import java.util.ArrayList;
import java.util.List;

public class Cargando implements EstadoCarrito{
    private List<Producto> ListaProductos = new ArrayList<>();
    @Override
    public void AgregarProducto(Producto producto) {
       ListaProductos.add(producto);
        System.out.println("producto agregado: " + producto.getDescripcion()+" Precio del producto: "+producto.getPrecio());
    }
    @Override
    public void CancelarCarrito() {
        System.out.println("carrito cancelado");
        ListaProductos.clear();
    }

    @Override
    public void RegresarPuntoAnterior() {
     CancelarCarrito();
    }

    @Override
    public void PasarEstado() {
        System.out.println("El carrito pasa al estado PAGANDO");
    }
}

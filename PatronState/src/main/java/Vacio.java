import java.util.List;

public class Vacio implements EstadoCarrito{
    @Override
    public void AgregarProducto(Producto producto) {
        System.out.println("producto agregado: " + producto.getDescripcion());
    }
    @Override
    public void CancelarCarrito() {
        System.out.println("Carrito cancelado");
    }
    @Override
    public void RegresarPuntoAnterior() {
    }
    @Override
    public void PasarEstado() {
        System.out.println("el carrito pasa a estar CARGANDO");
    }
}

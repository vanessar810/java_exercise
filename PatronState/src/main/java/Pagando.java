public class Pagando implements EstadoCarrito{
    @Override
    public void AgregarProducto(Producto producto) {
        System.out.println("en este punto no se agregar mas productos");
    }

    @Override
    public void CancelarCarrito() {
        System.out.println("compra cancelada");
    }

    @Override
    public void RegresarPuntoAnterior() {
        System.out.println("no se puede volver al punto anterior");
    }

    @Override
    public void PasarEstado() {
        System.out.println("el carrito esta cerrado, no se pueden cargar mas productos");

    }
}

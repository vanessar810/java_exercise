public class Cerrado implements EstadoCarrito{
    @Override
    public void AgregarProducto(Producto producto) {
        System.out.println("no se puede agregar mas producto");
    }

    @Override
    public void CancelarCarrito() {
        System.out.println("no se puede");
    }

    @Override
    public void RegresarPuntoAnterior() {
        System.out.println("no se puede");
    }

    @Override
    public void PasarEstado() {
        System.out.println("no se puede");
    }
}

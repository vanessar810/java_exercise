public interface EstadoCarrito {
    public void AgregarProducto(Producto producto);
    public void CancelarCarrito();
    public  void RegresarPuntoAnterior();
    public void PasarEstado();
}

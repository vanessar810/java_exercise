import java.util.ArrayList;
import java.util.List;

public class Carrito {
    protected EstadoCarrito estado;
    public Carrito(){ estado = new Vacio();}
    private List<Producto> ListaProductos = new ArrayList<>();

    public void AgregarProducto(Producto producto){
        estado.AgregarProducto(producto);
      ListaProductos.add(producto);
        }
    public void CancelarCarrito(){
        estado.CancelarCarrito();
        ListaProductos.clear();
    }
    public void RegresarPuntoAnterior(){
        estado.RegresarPuntoAnterior();
    }
    public void PasarEstado(){
        estado.PasarEstado();
        if (estado instanceof Vacio){
            estado = new Cargando();
        } else if (estado instanceof Cargando) {
            estado = new Pagando();
        } else if (estado instanceof Pagando) {
            estado = new Cerrado();
        } else if(estado instanceof Cerrado){
            estado = new Vacio();
        }
    }
}

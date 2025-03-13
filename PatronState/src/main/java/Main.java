public class Main {
    public static void main(String[] args) {
        Carrito carrito1 = new Carrito();
        Producto producto1 = new Producto("Jabon",15);
        Producto producto2 = new Producto("crema",30);
        Producto producto3 = new Producto("shampoo",20);
        Producto producto4 = new Producto("perfume",45);

        carrito1.AgregarProducto(producto1);
        carrito1.AgregarProducto(producto2);
        carrito1.AgregarProducto(producto3);
        carrito1.AgregarProducto(producto4);
       //1
        carrito1.PasarEstado();
        System.out.println("1 "+carrito1.estado);
        //
        carrito1.RegresarPuntoAnterior();
        //2
        carrito1.PasarEstado();
        System.out.println("2 "+carrito1.estado);
        //3
        carrito1.PasarEstado();
        System.out.println("3 "+carrito1.estado);
        //4
        carrito1.PasarEstado();
        System.out.println("4 "+carrito1.estado);


    }
}

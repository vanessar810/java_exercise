public class Cliente {
    public static void main(String[] args) {
     Product product1 = ProductFactory.CrearProducto("CAJA10X10");
        System.out.println(product1.calcularEspacio());
        Product product2 =ProductFactory.CrearProducto("PELOTAFUTBOL");
        System.out.println(product2.calcularEspacio());
        Product product3 =ProductFactory.CrearProducto("PELOTATENIS");
        System.out.println(product3.calcularEspacio());

        System.out.println("Total de productos creados: " + Product.getProductosCreados().size());
        System.out.println("Espacio total ocupado: " + Product.calcularEspacioTotal()+" cm3");
    }
}

public class ProductFactory {
public static  Product CrearProducto(String descripcion){
    if("CAJA10X10".equalsIgnoreCase(descripcion)){
 return new Caja(10,10,10);
    } else if ("PELOTAFUTBOL".equalsIgnoreCase(descripcion)) {
       return new Pelota(11);
    } else if ("PELOTATENIS".equalsIgnoreCase(descripcion)) {
return new Pelota(0.32);
    } else {
        throw new IllegalArgumentException("producto no valido");
    }
}

}

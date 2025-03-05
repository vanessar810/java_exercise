public class Main {
    public static void main(String[] args) {
      Contenedor contenedor0 = new Contenedor(0,"China",false);
        Contenedor contenedor1 = new Contenedor(6,"Desconocido",true);
        Contenedor contenedor2 = new Contenedor(4,"China",true);
        Contenedor contenedor3 = new Contenedor(3,"Desconocido",false);
        Contenedor contenedor4 = new Contenedor(2,"Desconocido",true);
        Contenedor contenedor5 = new Contenedor(5,"Desconocido",true);
        Contenedor contenedor6 = new Contenedor(1,"China",false);
        Puerto puerto1 = new Puerto("BS-AS");
        puerto1.agregarContenedor(contenedor0);
        puerto1.agregarContenedor(contenedor1);
        puerto1.agregarContenedor(contenedor2);
        puerto1.agregarContenedor(contenedor3);
        puerto1.agregarContenedor(contenedor4);
        puerto1.agregarContenedor(contenedor5);
        puerto1.agregarContenedor(contenedor6);
        puerto1.mostrarContenedores();
        puerto1.contenedorPeligrosoDesconocido();
    }
}

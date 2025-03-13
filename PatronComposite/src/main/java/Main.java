public class Main {
    public static void main(String[] args) {
        Figura triangulo1 = new Triangulo("triangulo1",2, 1);
        Figura triangulo2 = new Triangulo("triangulo2",4, 2);
        Figura circulo1 = new Circulo("circulo1",2);
        Figura circulo2 = new Circulo("circulo2",2);
        Figura circulo3 = new Circulo("circulo3",2);
        Figura circulo4 = new Circulo("circulo4",2);
        Figura rectangulo = new Rectangulo("rectangulo",6, 3);

        Trensito trensito1 = new Trensito();
        trensito1.agregarFiguras(triangulo1);
        trensito1.agregarFiguras(triangulo2);
        trensito1.agregarFiguras(circulo1);
        trensito1.agregarFiguras(circulo2);
        trensito1.agregarFiguras(circulo3);
        trensito1.agregarFiguras(circulo4);
        trensito1.agregarFiguras(rectangulo);
        trensito1.ListarFiguras();
        System.out.println("el área total del trensito es: "+ trensito1.AreaTotal()+" cm");


    }
}


public class Main {
    public static void main(String[] args) {
        Subasta subasta1 = new Subasta(200,"pintura roja");
        Subasta subasta2 = new Subasta(300,"cuadro verde");
        Oferente oferente1 =new Oferente("Daniel",500);
        Oferente oferente2 =new Oferente("laura",150);
        Oferente oferente3 =new Oferente("sofia",350);
        Oferente oferente4 =new Oferente("camilo",400);
        Oferente oferente5 =new Oferente("raul",100);
        subasta1.agregarOferente(oferente1);
        subasta1.agregarOferente(oferente2);
        subasta1.agregarOferente(oferente3);
        subasta1.agregarOferente(oferente4);
        subasta1.agregarOferente(oferente5);
        subasta1.Monto();
        subasta1.Ofertar();

    }
}

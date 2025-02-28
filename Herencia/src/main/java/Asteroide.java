public class Asteroide extends ObjetoGrafico{
    public int lesion;

    public Asteroide(int posx, int posy, char direccion, int lesion) {
        super(posx, posy, direccion);
        this.lesion = lesion;
    }

    @Override
    public String irA(int x, int y, char direccion) {
        return super.irA(x, y, direccion);
    }
}

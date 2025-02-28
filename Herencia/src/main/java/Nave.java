public class Nave extends ObjetoGrafico {
    private double velocidad;
    private int vida;

    public Nave(int posx, int posy, char direccion, double velocidad, int vida) {
        super(posx, posy, direccion);
        this.velocidad = velocidad;
        this.vida = vida;
    }
    @Override
    public String irA(int x, int y, char direccion) {
        return super.irA(x, y, direccion);
    }

    public char girar(char direccion){
        return direccion;
    }

    public int restaVida(int valor){
        return this.vida=+vida-valor;
    }
}

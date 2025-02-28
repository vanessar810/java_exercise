public class ObjetoGrafico {
    private int posx;
    private int posy;
    private char direccion;

    public ObjetoGrafico(int posx, int posy, char direccion) {
        this.posx = posx;
        this.posy = posy;
        this.direccion = direccion;
    }
public String irA(int x, int y, char direccion){
        return "vamos a "+x+", "+y+" en dirección "+direccion;

}

}

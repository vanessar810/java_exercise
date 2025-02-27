public class UsuarioJuego {
    private String nombre;
    private String clave;
    private int puntaje =0;
    private int nivel=0;

    public UsuarioJuego(String nombre, String clave, int puntaje, int nivel) {
        this.nombre = nombre;
        this.clave = clave;
        this.puntaje = puntaje;
        this.nivel = nivel;
    }

    public void aumentarPuntaje(){
       this.puntaje = +puntaje +1;
    }

    public void subirNivel(){
        this.nivel =+nivel +1;

    }
    public void bonus(int bonus1){
     this.puntaje = +puntaje+ bonus1;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getNivel() {
        return nivel;
    }
}

public class Prueba {
    public static void main(String[] args) {
        UsuarioJuego usuario1 = new UsuarioJuego("vane", "vr2025",0,0);
        usuario1.aumentarPuntaje();
        usuario1.subirNivel();
        usuario1.bonus(5);
        System.out.println("El nivel del usuario "+usuario1.getNombre()
                +" es "+usuario1.getNivel()+". puntaje:"+usuario1.getPuntaje());
    }
}

public class Main {
    public static void main(String[] args) {
        Nave nave1 = new Nave(1,1,'N',5,5);
        System.out.println(nave1.irA(1,1,'N'));
        System.out.println("ahora vamos en dirección "+nave1.girar('S'));
        Asteroide asteroide = new Asteroide(1,1,'S',-1);
        System.out.println("te ha golpeado un asteroide que cambio tu dirección: "+asteroide.irA(0,0,'O')+ ", y te quito "+asteroide.lesion+" vida");
        System.out.println("ahora tienes "+nave1.restaVida(1)+" vidas");
    }
}

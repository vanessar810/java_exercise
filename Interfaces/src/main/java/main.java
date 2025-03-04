public class main {
    public static void main(String[] args) {
        Tanque tanque1 = new Tanque(100, "tanque1");
        tanque1.mostrar();
        System.out.println(tanque1.ataque());
        System.out.println( tanque1.defensa());
        RobotPesado robotPesado = new RobotPesado(90,"Rpesado1");
        robotPesado.mostrar();
        System.out.println(robotPesado.ataque());
        System.out.println(robotPesado.defensa());
        robotPesado.volar();
        RobotLiviano robotLiviano = new RobotLiviano(80,"Rliviano");
        robotLiviano.mostrar();
        System.out.println(robotLiviano.ataque());
        System.out.println(robotLiviano.defensa());
        robotLiviano.volar();


    }
}

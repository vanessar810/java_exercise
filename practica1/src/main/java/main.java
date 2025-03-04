public class main {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("pablito", "diaz",111);
        Parcial parcial1 = new Parcial("Matematicas",5,alumno1,3,1);
        System.out.println(parcial1.aprobado());
        Final final1 = new Final("musica",4,alumno1,5,2);
        System.out.println(final1.aprobado());
    }
}

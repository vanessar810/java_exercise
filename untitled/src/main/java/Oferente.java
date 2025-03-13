public class Oferente implements Observer{
    private String nombre;
    private double montoTope;

    public Oferente(String nombre, double montoTope) {
        this.nombre = nombre;
        this.montoTope = montoTope;
    }

    public double getMontoTope() {
        return montoTope;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void RecibeMontoSubasta(String mensaje) {
        System.out.println(this.nombre+" fue notificado con: "+mensaje);
    }
}

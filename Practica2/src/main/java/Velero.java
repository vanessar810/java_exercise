public class Velero extends Embarcacion {
    private Integer mastiles;

    public Velero(Capitan capitan, double precioBase, double precioAdicional, Integer fabricationYear, Integer length, Integer mastiles) {
        super(capitan, precioBase, precioAdicional, fabricationYear, length);
        this.mastiles = mastiles;
    }

    @Override
    public double Alquiler() {
        return super.Alquiler();
    }

    public void esGrande() {
        if (mastiles > 4) {
            System.out.println("el velero es grande");
        } else{
        System.out.println("el velero no es grande");}
    }
}

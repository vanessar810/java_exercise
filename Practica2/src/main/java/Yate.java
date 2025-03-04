public class Yate extends Embarcacion{
    private Integer camarotes;

    public Yate(Capitan capitan, double precioBase, double precioAdicional, Integer fabricationYear, Integer length, Integer camarotes) {
        super(capitan, precioBase, precioAdicional, fabricationYear, length);
        this.camarotes = camarotes;
    }

    @Override
    public double Alquiler() {
        return super.Alquiler();
    }
    public boolean mayorLujo(Yate otroYate){
        return camarotes> otroYate.camarotes;
    }
}

public class Embarcacion {
    private Capitan capitan;
    private double precioBase;
    private double precioAdicional;
    private Integer fabricationYear;
    private Integer  length;

    public Embarcacion(Capitan capitan, double precioBase, double precioAdicional, Integer fabricationYear, Integer length) {
        this.capitan = capitan;
        this.precioBase = precioBase;
        this.precioAdicional = precioAdicional;
        this.fabricationYear = fabricationYear;
        this.length = length;
    }

    public double Alquiler(){
        if(fabricationYear>2020){
            double precioAlquiler = precioBase + precioAdicional;
            return precioAlquiler;
        }
        double precioAlquiler = precioBase;
        return precioAlquiler;
    }
}

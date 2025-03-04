public class SistemaArmas {
    protected Integer energia;

    public SistemaArmas(Integer energia) {
        this.energia = energia;
    }

    public Integer getEnergia() {
        return energia;
    }
    public void mostrar(){
        System.out.println("la energía de tu arma es: "+energia);
    };
}

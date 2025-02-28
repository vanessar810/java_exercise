public class Cliente {
    private int numeroCliente;
    private String name;
    private int DNI;
    private int CUIT;

    public Cliente(int numeroCliente, String name, int DNI, int CUIT) {
        this.numeroCliente = numeroCliente;
        this.name = name;
        this.DNI = DNI;
        this.CUIT = CUIT;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }
}

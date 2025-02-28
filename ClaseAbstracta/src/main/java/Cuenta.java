public abstract class Cuenta {
    private int numeroCuenta;
    protected double saldo;
    private Cliente cliente;

    public Cuenta(int numeroCuenta, double saldo, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public abstract String Depositar(double monto);

    public abstract String ExtraerDinero(double monto);


    public abstract String InformarSaldo();

}

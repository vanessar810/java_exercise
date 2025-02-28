public class CuentaCorriente extends Cuenta{
 private static double descubierto = 2000;

    public CuentaCorriente(int numeroCuenta, double saldo, Cliente cliente) {
        super(numeroCuenta, saldo, cliente);
        this.descubierto = descubierto;
    }

    @Override
    public String Depositar(double monto) {
        saldo += monto;
        return "se ha depositado "+monto+ " exitosamente";
    }

    @Override
    public String ExtraerDinero(double monto) {
        if (monto > saldo + descubierto) {
            return "el monto excede descubierto";
        }
        if (monto > saldo && monto < descubierto) {
            descubierto -= monto;
            return "retiro exitoso, su saldo descubierto es " + descubierto;
        } saldo -= monto;
        return "su nuevo saldo es "+saldo;
    }

    @Override
    public String InformarSaldo() {
        return "su saldo es "+ saldo;
    }
}

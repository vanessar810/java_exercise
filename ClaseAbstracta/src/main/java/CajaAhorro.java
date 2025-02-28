public class CajaAhorro extends Cuenta{
    private double tasaInteres;

    public CajaAhorro(int numeroCuenta, double saldo, Cliente cliente, double tasaInteres) {
        super(numeroCuenta, saldo, cliente);
        this.tasaInteres = tasaInteres;
    }

       @Override
    public String Depositar(double monto) {
        saldo=+ monto;
        return "se ha depositado "+monto;
    }
    @Override
    public String ExtraerDinero(double monto) {
        if (monto<saldo){
            return "no se puede extraer dinero";
        }
        saldo=- monto;
        return "retiro exitoso";
    }
    @Override
    public String InformarSaldo() {
        return "su saldo es"+ saldo;
    }

    public String CobrarInteres(){
     saldo = saldo*(1+tasaInteres);
     return "su saldo más intereses es: "+saldo;
    }
}

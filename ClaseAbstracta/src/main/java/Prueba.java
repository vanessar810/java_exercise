public class Prueba {
    public static void main(String[] args) {
     Cliente cliente1 = new Cliente(1,"vane",1010,1111);
     CajaAhorro caja1 = new CajaAhorro(111,500,cliente1,0.012);
        System.out.println(caja1.Depositar(200));
        System.out.println(caja1.InformarSaldo());
        System.out.println(caja1.ExtraerDinero(50));
        System.out.println(caja1.InformarSaldo());
        System.out.println(caja1.CobrarInteres());

     Cliente cliente2 = new Cliente(2, "ros",22,33);
     CuentaCorriente cuentaCorriente1 = new CuentaCorriente(121,600,cliente2);
        System.out.println(cuentaCorriente1.Depositar(300));
        System.out.println(cuentaCorriente1.InformarSaldo());
        System.out.println(cuentaCorriente1.ExtraerDinero(200));
    }
}

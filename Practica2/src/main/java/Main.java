public class Main {
    public static void main(String[] args) {

        Capitan capitan = new Capitan("Pilo", "Rachas",12);
        Velero velero1 = new Velero(capitan,1000,200,2021,5,5);
        System.out.println(velero1.Alquiler());
        Velero velero2 = new Velero(capitan,800,0,2019,2,1);
        System.out.println(velero2.Alquiler());
        velero1.esGrande();
        velero2.esGrande();
        Yate yate1 = new Yate(capitan, 1500,300,2024,5,6);
        Yate yate2 = new Yate(capitan,1200,100,2021,3,2);
        System.out.println(yate1.Alquiler());
        System.out.println(yate2.Alquiler());
        System.out.println(yate1.mayorLujo(yate2));

    }
}

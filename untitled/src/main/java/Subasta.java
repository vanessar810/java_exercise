import java.util.ArrayList;
import java.util.List;

public class Subasta {
    private double monto;
    private String descripcion;

    private List<Oferente> oferentes= new ArrayList<>();
    public void agregarOferente(Oferente oferente){
        oferentes.add(oferente);
    }
    public void Monto(){
        String mensaje = this.descripcion +" se subasta por " + this.monto;
        NotificarMonto(mensaje);
    }

    public Subasta(double monto, String descripcion) {
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public void NotificarMonto(String mensaje){
        for(Oferente oferente : oferentes)
        oferente.RecibeMontoSubasta(mensaje);
    }
    public void Ofertar(){
        for (Oferente oferente : oferentes)
            if (monto<oferente.getMontoTope()){
                System.out.println(oferente.getNombre()+ " Quiere ofertar por: "+oferente.getMontoTope());
            } else
                System.out.println(oferente.getNombre()+" No puede ofertar");
    }
}

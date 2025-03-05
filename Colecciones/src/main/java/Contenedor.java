public class Contenedor implements CompararIdentificacion{
 private int identificacion;
 private String paisProcedencia;

 private boolean materialesPeligrosos;


    public Contenedor(Integer identificacion, String paisProcedencia, boolean materialesPeligrosos) {
        this.identificacion = identificacion;
        this.paisProcedencia = paisProcedencia;
        this.materialesPeligrosos = materialesPeligrosos;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public boolean isMaterialesPeligrosos() {
        return materialesPeligrosos;
    }
    public int compareTo(Contenedor otroContenedor){
        return Integer.compare(identificacion, otroContenedor.identificacion);
    }

}


public class Parcial extends Examen {
    private Integer numeroUnidad;
    private Integer numeroIntentos;

    public Parcial(String titulo, double nota, Alumno Alumno, Integer numeroUnidad, Integer numeroIntentos) {
        super(titulo, nota, Alumno);
        this.numeroUnidad = numeroUnidad;
        this.numeroIntentos = numeroIntentos;
    }

    @Override
    public String aprobado() {
        if (nota >= 4) {
            return "el examen de "+titulo+" está aprobado";
        }
        return "el examen de "+titulo+" no fue aprobado";
    }

    public boolean sePuedeRecuperar(){
        if(numeroUnidad <= 3 && numeroIntentos <= 3) {
            return true;
        } if(numeroUnidad >3 && numeroIntentos <=2){
            return true;
        }
        return false;
    }
}

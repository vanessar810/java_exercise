public class Final extends Examen{
    private double notaOral;
    private double notaEscrita;

    public Final(String titulo, double nota, Alumno Alumno, double notaOral, double notaEscrita) {
        super(titulo, nota, Alumno);
        this.notaOral = notaOral;
        this.notaEscrita = notaEscrita;
    }

    double promedio = (notaEscrita + notaOral)/2;
    @Override
    public String aprobado() {

        if(promedio>=4){
            return "el examen de "+titulo+" está aprobado";
        }
        return  "el examen de "+titulo+" no fue aprobado";
    }
}

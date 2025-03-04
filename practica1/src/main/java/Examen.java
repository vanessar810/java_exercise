public class Examen {
    protected String titulo;
    protected double nota;

    public Alumno Alumno;

    public Examen(String titulo, double nota, Alumno Alumno) {
        this.titulo = titulo;
        this.nota = nota;
        this.Alumno = Alumno;
    }
public String aprobado(){
return "";
}

    public double getNota() {
        return nota;
    }
}




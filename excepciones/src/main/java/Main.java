import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws PacienteExcepcion {
        LocalDate fecha1 = LocalDate.of(2025,3,5);
        LocalDate fecha2 = LocalDate.of(2025,2,20);
        Paciente paciente1 = new Paciente("leon","díaz",11,fecha1,fecha2);
        paciente1.ValidarFechaInt();
        paciente1.validarFechaAlta();
    }
}

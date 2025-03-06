import java.time.LocalDate;

public class Paciente {
    private String name;
    private String lastname;
    private int DNI;
    private LocalDate fechaInt;
    private LocalDate fechaAlt = null;

    public Paciente(String name, String lastname, int DNI, LocalDate fechaInt, LocalDate fechaAlt) {
        this.name = name;
        this.lastname = lastname;
        this.DNI = DNI;
        this.fechaInt = fechaInt;
        this.fechaAlt = fechaAlt;
    }
    public void ValidarFechaInt() throws PacienteExcepcion{
        LocalDate hoy = LocalDate.now();
        if(fechaInt.isBefore(hoy) || fechaInt.isEqual(hoy)){
            System.out.println("se ha realizado exitosamente el ingreso en: "+fechaInt);
        } else {
            throw new PacienteExcepcion("No se puede procesar solicitud, fecha ingresada es posterior a hoy");
        }
    }

    public void validarFechaAlta() throws PacienteExcepcion{
        if(fechaAlt.isAfter(fechaInt) || fechaAlt.isEqual(fechaInt)){
            System.out.println("el paciente se ha dado de alta en: "+fechaAlt);
        } else {
            throw new PacienteExcepcion("La fecha de alta no puede ser anterior a la fecha de ingreso");
        }
    }
}

public class Alumno {
    private String name;
    private String lastname;
    private Integer legajo;

    public Alumno(String name, String lastname, Integer legajo) {
        this.name = name;
        this.lastname = lastname;
        this.legajo = legajo;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getLegajo() {
        return legajo;
    }
}

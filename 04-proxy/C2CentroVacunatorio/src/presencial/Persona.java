package presencial;

import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String nombreVacuna;
    private Date fechaVacuna;

    public Persona(String nombre, String apellido, String cedula, String nombreVacuna, Date fechaVacuna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombreVacuna = nombreVacuna;
        this.fechaVacuna = fechaVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }
}

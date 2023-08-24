package presencial;

public class EmpleadoEfectivo extends Empleado{
    private double sueldoBasico;
    private double descuentos;
    private double premios;

    public EmpleadoEfectivo(String nombre, String apellido, String cuentaBancaria, double sueldoBasico, double descuentos, double premios) {
        super(nombre, apellido, cuentaBancaria);
        this.sueldoBasico = sueldoBasico;
        this.descuentos = descuentos;
        this.premios = premios;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getPremios() {
        return premios;
    }

    public void setPremios(double premios) {
        this.premios = premios;
    }
}

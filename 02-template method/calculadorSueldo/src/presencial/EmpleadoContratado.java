package presencial;

public class EmpleadoContratado extends Empleado{
    private Integer cantHoras;
    private double valorPorHora;

    public EmpleadoContratado(String nombre, String apellido, String cuentaBancaria, Integer cantHoras, double valorPorHora) {
        super(nombre, apellido, cuentaBancaria);
        this.cantHoras = cantHoras;
        this.valorPorHora = valorPorHora;
    }

    public Integer getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(Integer cantHoras) {
        this.cantHoras = cantHoras;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
}

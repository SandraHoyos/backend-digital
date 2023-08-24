package presencial;

public class ContadorEmpleadoContratado  extends Contador{
    private String liquidarSueldo;

    @Override
    protected Double calcularSueldo(Empleado empleado) {
        Double respuesta= 0.0;
        if(empleado instanceof EmpleadoContratado){
            EmpleadoContratado contratado= (EmpleadoContratado) empleado;
            respuesta= contratado.getValorPorHora()*contratado.getCantHoras();
        }

        return respuesta;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidación generada es un documento digital.";
    }
}

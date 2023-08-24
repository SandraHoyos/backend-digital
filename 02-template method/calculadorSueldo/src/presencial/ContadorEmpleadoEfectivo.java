package presencial;

public class ContadorEmpleadoEfectivo extends Contador{

    @Override
    protected Double calcularSueldo(Empleado empleado) {
        Double respuesta= 0.0;
        if(empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo efectivo= (EmpleadoEfectivo) empleado;
            respuesta= efectivo.getSueldoBasico()+efectivo.getPremios()-efectivo.getDescuentos();
        }
        return respuesta;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidación es un documento escrito";
    }
}

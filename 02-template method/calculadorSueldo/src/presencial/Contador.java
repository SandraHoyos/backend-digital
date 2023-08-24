package presencial;

public abstract class Contador {
    public String liquidarSueldo(Empleado empleado){
        //ACA VIENE EL METODO TEMPLATE METHOD
        String respuesta= "La Liquidación no se pudo realizar";
        Double sueldo= calcularSueldo(empleado);
        if (sueldo>0.0){
            //si es mayor
            String recibo= emitirRecibo(empleado);
            String deposito= depositarSueldo(empleado);
            respuesta= recibo+" Sueldo a liquidar y a percibir por el trabajador es : "+sueldo;
        }
        return respuesta;
    }
    private String depositarSueldo(Empleado empleado){
        return "orden de deposito en la cuenta: "+empleado.getCuentaBancaria();
    }
    protected abstract Double calcularSueldo(Empleado empleado);
    protected abstract String emitirRecibo(Empleado empleado);
}

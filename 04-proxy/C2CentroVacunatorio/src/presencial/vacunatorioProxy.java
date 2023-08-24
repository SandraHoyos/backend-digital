package presencial;

import java.util.Date;

public class vacunatorioProxy implements vacunatorioInterface{
    //estamos haciendo una relacion de asociacion
    private centroVacunatorio centroVacunatorio;

    public vacunatorioProxy() {
        centroVacunatorio= new centroVacunatorio();
    }

    @Override
    public String vacunar(Persona persona) {
        //controlar
        //verficar
        //ser el intermediario
        Date fecha= new Date();
        System.out.println("La fecha de hoy es:::::"+fecha);
        System.out.println("Fecha asignada de la vacuna: "+persona.getFechaVacuna());
        if(fecha.before(persona.getFechaVacuna())){
            return centroVacunatorio.vacunar(persona);

        }else{
            return "Vuelva cuando sea su turno";
        }
    }
}

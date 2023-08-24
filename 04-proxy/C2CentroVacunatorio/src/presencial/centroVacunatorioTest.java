package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class centroVacunatorioTest {
    @Test
    public void casoProxyOk(){
        //DADO
        Persona persona = new Persona("Andres","Gonzalez","2233344","Pfzier",new Date(2023-1900,07,10));
        vacunatorioProxy centro= new vacunatorioProxy();
        String respEsp= "Vuelva cuando sea su turno";
        //CUANDO
        String respActual= centro.vacunar(persona);
        //ENTONCES
        Assertions.assertEquals(respEsp,respActual);
    }
    @Test
    public void casoProxyPass(){
        //dado
        Persona persona= new Persona("Jorgito","Pereyra","11111","moderna",new Date(2023-1900,06,27));
        vacunatorioProxy centro= new vacunatorioProxy();
        String respEsp= "El paciente :Jorgito Pereyra fue vacunado con exito";
        //cuando
        String respActual= centro.vacunar(persona);
        //entonces
        Assertions.assertEquals(respEsp,respActual);
    }

}

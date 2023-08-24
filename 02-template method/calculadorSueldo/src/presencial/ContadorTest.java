package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContadorTest {
    @Test
    public void liquidarSueldoEmpleadoContratado(){
        //DADO
        Empleado jorgito= new EmpleadoContratado("Jorgito","Pereyra","1111111",40,100);
        Contador digitalHouse= new ContadorEmpleadoContratado();
        String respEsp= "La liquidación es un documento digital 4000 ";
        //CUANDO
        String liquidacion= digitalHouse.liquidarSueldo(jorgito);
        //ENTONCES
        Assertions.assertEquals(respEsp,liquidacion);
    }
}

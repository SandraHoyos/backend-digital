package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrupoTest {
    private Persona pedro;

    @Test
    public void agregarGrupo2Personas(){
        //DADO
        //valores iniciales
        Persona juan= new Persona("Juan",20);
        Persona pedro= new Persona("P3dro",21);
        Persona ana= new Persona("Ana",22);
        Persona luz= new Persona("Luz",23);
        Persona julian= new Persona("Julian",24);
        Grupo grupo= new Grupo();
        //CUANDO
        grupo.agregarPersona(juan);
        grupo.agregarPersona(pedro);
        grupo.agregarPersona(ana);
        grupo.agregarPersona(luz);
        grupo.agregarPersona(julian);
        //ENTONCES
        Assertions.assertTrue(grupo.getPersonas().size()==2);
    }
}

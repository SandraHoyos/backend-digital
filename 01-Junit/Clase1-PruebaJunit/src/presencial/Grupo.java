package presencial;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;
    public List<Persona> getPersonas(){
        return personas;
    }

    public Grupo() {
       personas= new ArrayList<>();
    }
    public void agregarPersona(Persona persona){
        boolean checkMayoria= persona.esMayorDeEdad();
        boolean checkCantDeLetras= persona.cantDeLetras();
        boolean soloLetras= persona.checkLetrasAZ();
        boolean checkEdad= persona.checkEdad();
        if(checkEdad && checkMayoria && checkCantDeLetras && soloLetras){
            this.personas.add(persona);
        }else{
            System.out.println("No pude agregar a la persona debido a que no cumple con alguna condicion : "+persona.getNombre());
        }
    }
}

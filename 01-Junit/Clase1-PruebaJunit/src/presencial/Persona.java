package presencial;

public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }
    public boolean checkEdad(){
        boolean respuesta= false;
        if(this.edad>0 &&this.edad<=120){
            respuesta=true;
        }
        return respuesta;
    }
    public boolean cantDeLetras(){
        return this.nombre.length()>4;
    }
    public boolean checkLetrasAZ(){
    boolean respuesta= false;
    char[] array= this.nombre.toCharArray();
    for (int i=0; i< array.length;i++){
        char letra=array[i];
        if(!Character.isLetter(letra)){
            return respuesta;
        }
    }
    respuesta=true;
    return respuesta;

    }
}

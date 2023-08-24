package presencial;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private static  Map<String,Computadora> computadoraMap;
    public ComputadoraFactory(){
        computadoraMap= new HashMap<>();
    }
   public Computadora getComputadora(Integer ram, Integer discoDuro){
        //lo primero que hariamos es preguntar si existe o no
       String clave= "k:"+ram+discoDuro;
       if(!computadoraMap.containsKey(clave)){
           computadoraMap.put(clave,new Computadora(ram,discoDuro));
           System.out.println("Clave creada: "+clave);
       }
       System.out.println("Objeto reutilizado");
       return computadoraMap.get(clave);


   }

}

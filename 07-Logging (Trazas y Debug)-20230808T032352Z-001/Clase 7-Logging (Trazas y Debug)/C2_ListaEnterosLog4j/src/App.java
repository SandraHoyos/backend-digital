import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger= Logger.getLogger(App.class);
    private List<Integer> listaEnteros/*= new ArrayList<>()*/;

    public App(){
        listaEnteros= new ArrayList<>();
    }
    public void agregarEnteros(Integer numero){
        listaEnteros.add(numero);
        if(listaEnteros.size()>5){
            logger.error("La lista tiene elementos: "+listaEnteros.size());
            //tenemos que logear, tenemos que anotarlo en nuestra bitacora.
        }
    }
}

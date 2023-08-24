package presencial;

import java.util.ArrayList;
import java.util.List;

public class Bosque {
    private final List<Arbol> arboles= new ArrayList<>();
    public void plantarArboles(int alto, int ancho, String color, String tipoarbol){
        Arbol arbol= ArbolFactory.obtenerArbol(alto, ancho, color, tipoarbol);
        arboles.add(arbol);
    }
    public List<Arbol> getArboles(){
        return arboles;
    }
}

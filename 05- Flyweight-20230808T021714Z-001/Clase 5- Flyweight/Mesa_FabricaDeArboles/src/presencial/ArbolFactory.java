package presencial;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArbolFactory {
    private static Map<String,Arbol> arbolMap= new HashMap<>();
    private static Integer arbolcreado=0;
    private static Integer arbolReutilizado=0;
    public static Arbol obtenerArbol(int alto, int ancho, String color, String tipoarbol){
        Arbol arbol= arbolMap.get(tipoarbol);
        if(Objects.isNull(arbol)){
            arbol= new Arbol(alto, ancho, color, tipoarbol);
            arbolMap.put(tipoarbol,arbol);
            arbolcreado++;
            System.out.println("Cantidad de arboles creados: "+arbolcreado);
            return arbol;
        }else {
        arbolReutilizado++;
        System.out.println("Arbol reutilizados: "+arbolReutilizado);
        return arbol;}


    }
}

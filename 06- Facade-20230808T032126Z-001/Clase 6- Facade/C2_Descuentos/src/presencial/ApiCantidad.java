package presencial;

public class ApiCantidad {
    public static int descuentoXCantidad(int cantidad){
        //tengo que evaluar la condicion > 12
        if(cantidad>12){
            return 15;
        }else{
        return 0;}
    }
}

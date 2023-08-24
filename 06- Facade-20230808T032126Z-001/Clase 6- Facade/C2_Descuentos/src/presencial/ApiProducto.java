package presencial;

public class ApiProducto {
    public static int descuentoXProducto(Producto producto){
        //la condicion
        if(producto.getTipo().equals("latas")){
            return 10;
        }else{
        return 0;}
    }
}

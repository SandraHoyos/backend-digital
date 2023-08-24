package presencial;

public class ApiTarjeta {
    public static int descuentoPorTarjeta(Tarjeta tarjeta){
        //la condicion
        if(tarjeta.getBancoEmisor().equalsIgnoreCase("star bank")){
            return 20;
        }else{
        return 0;}
    }
}

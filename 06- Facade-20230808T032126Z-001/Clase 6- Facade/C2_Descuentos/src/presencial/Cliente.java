package presencial;

public class Cliente {
    public static void main(String[] args) {
        //que necesito instanciar
        Producto producto= new Producto("Coca Cola","Latas");
        Tarjeta tarjeta= new Tarjeta(11111111,"Star bank");
        int cantidad= 5;
        FachadaDescuento fachada= new FachadaDescuento();
        System.out.println("Descuentos acumulados:   "+fachada.calcularDescuento(tarjeta,producto,cantidad));
    }
}

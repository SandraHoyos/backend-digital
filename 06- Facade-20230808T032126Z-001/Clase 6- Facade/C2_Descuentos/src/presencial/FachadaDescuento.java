package presencial;

public class FachadaDescuento implements Descuento{

    @Override
    public int calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        int descuento=0;
        descuento= descuento+ ApiTarjeta.descuentoPorTarjeta(tarjeta);
        descuento= descuento+ApiProducto.descuentoXProducto(producto);
        descuento= descuento+ApiCantidad.descuentoXCantidad(cantidad);
        return descuento;
    }
}

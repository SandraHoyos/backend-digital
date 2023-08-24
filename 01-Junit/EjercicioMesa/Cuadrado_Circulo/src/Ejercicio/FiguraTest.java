package Ejercicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.PlainDocument;

public class FiguraTest {
    @Test
    public void calcularElAreaCirculo6() {
        //dado
         Figura circulo = new Circulo(6.0);
         String respuestaEsperada= "el area del circulo es 113.0973355292325 unidades";

        //cuando
        String area= circulo.calcularArea();
        //entonces
        Assertions.assertEquals(respuestaEsperada,area);
    }
    @Test
    public void calcularElAreaCuadrado5(){
        //DADO
        Figura cuadrado=new Cuadrado(5);
        String respuesta= "el area del cuadrado es de 25 unidades";
        //CUADNO
        String cuadrados= cuadrado.calcularArea();
        //ENTONCES
        Assertions.assertEquals(respuesta,cuadrados);

    }
}

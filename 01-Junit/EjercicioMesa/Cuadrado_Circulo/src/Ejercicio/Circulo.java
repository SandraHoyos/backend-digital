package Ejercicio;
/*/*ejecutamos en ambas clases el metodo implements @override para la clase abstracta*/
/*Declaramos la varibale cuadrado y radio en circulo*/
/*obtenemos el contructor, getter y setter*/
public class Circulo implements Figura {
private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public String calcularArea() {
        //Realizado el override anterior calculamos ahora la circunsferencia del circulo.
        //apartir de este momento podriamos implementar el test, para eso recordemos crear la clase test e importar la libreria
        if (radio > 0) {
            return "el area del circulo es " + Math.PI * Math.pow(radio, 2)+ " unidades";
        }
        else {
            return "No se puede calcular un 0 o negativo";
        }
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}

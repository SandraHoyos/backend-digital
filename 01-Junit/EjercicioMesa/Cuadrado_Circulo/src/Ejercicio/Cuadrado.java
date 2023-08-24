package Ejercicio;
/*ejecutamos en ambas clases el metodo implements @override para la clase abstracta*/
/*Declaramos la varibale cuadrado y radio en circulo*/
/*obtenemos el contructor, getter y setter*/
public class Cuadrado implements Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public String calcularArea() {
        //tambien se podria haber usado Math.pow(lado,2);
        return "el area es de "+lado*lado+ "unidades";
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}

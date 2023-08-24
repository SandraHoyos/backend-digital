package Ejercicio;

public interface Figura {
    /*Si lo hacemos con double despues deberiamos convertir para poder mostrarlo, por eso nosotros usamos String
    * Para la prueba es mejor, sino la deberiamos hacer solo con el area*/
    /*La interfaz tendria que tener un metodo para calcular el area que nos permita que las demás clases
     puedan inplementar la función */
    String calcularArea();
    /*apartir de esto podemos crear las clases Circulo y cuadrado,
    lo que si ambas clases van a tener implements como elemento para ejecutar la interfaz*/
}

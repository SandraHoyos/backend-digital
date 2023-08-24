package presencial;

public class Vivero {
    public static void main(String[] args) {
        Bosque bosque= new Bosque();
       for(int i=0;i<10;i++){
           bosque.plantarArboles(200,400,"verde","ORNAMENTALES");
           bosque.plantarArboles(500,300,"rojo","FRUTAL");
           bosque.plantarArboles(100,200,"celeste", "FLORALES");

       }
        //Usando esta sentencia se podrá ver la memoria usada:
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}

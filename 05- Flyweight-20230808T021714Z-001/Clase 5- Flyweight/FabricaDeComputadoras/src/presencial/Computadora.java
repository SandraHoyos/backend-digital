package presencial;

public class Computadora {
    //atributos
    private Integer ram;
    private Integer discoDuro;
    private String id;
    private static Integer contador=0;

    public Computadora(Integer ram, Integer discoDuro) {
        this.ram = ram;
        this.discoDuro = discoDuro;
        id="Mem:"+ram+"D:"+discoDuro; //etiqueta interna propia del negocio
        contador++;
        System.out.println("Objetos creado"+contador);

    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(Integer discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

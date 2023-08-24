package presencial;

public class Arbol {
    private int alto;
    private int ancho;
    private String color;
    private String tipoarbol;

    public Arbol(int alto, int ancho, String color, String tipoarbol) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipoarbol = tipoarbol;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoarbol() {
        return tipoarbol;
    }

    public void setTipoarbol(String tipoarbol) {
        this.tipoarbol = tipoarbol;
    }
}
